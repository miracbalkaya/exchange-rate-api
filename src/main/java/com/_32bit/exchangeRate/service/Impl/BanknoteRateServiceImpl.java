package com._32bit.exchangeRate.service.Impl;

import com._32bit.exchangeRate.controller.dto.enums.FilterType;
import com._32bit.exchangeRate.controller.dto.request.FilterRequest;
import com._32bit.exchangeRate.controller.dto.response.CurrencyDTO;
import com._32bit.exchangeRate.controller.dto.response.DataResponse;
import com._32bit.exchangeRate.repository.BanknoteRateRepository;
import com._32bit.exchangeRate.repository.model.BanknoteRate;
import com._32bit.exchangeRate.repository.specification.BanknoteRateSpecification;
import com._32bit.exchangeRate.service.FilterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BanknoteRateServiceImpl implements FilterTypeService {

    private final BanknoteRateRepository banknoteRateRepository;

    private static final String CREATED_DATE = "createDate";

    @Override
    public DataResponse filter(FilterRequest filterRequest) {
        Specification<BanknoteRate> specification = BanknoteRateSpecification.get(filterRequest);
        Sort sort = Sort.by(Sort.Direction.DESC, CREATED_DATE);
        List<BanknoteRate> all = banknoteRateRepository.findAll(specification, sort);

        return convertToDto(all);
    }

    @Autowired
    public BanknoteRateServiceImpl(BanknoteRateRepository banknoteRateRepository) {
        this.banknoteRateRepository = banknoteRateRepository;
    }


    @Override
    public FilterType getFilterType() {
        return FilterType.BANKNOTE;
    }

    private DataResponse convertToDto(List<BanknoteRate> banknoteRateList) {
        DataResponse response = new DataResponse();

        response.setBanknote(banknoteRateList.stream().map(this::convertToDto).collect(Collectors.toList()));
        return response;
    }

    private CurrencyDTO convertToDto(BanknoteRate banknoteRate) {
        return CurrencyDTO.builder()
                .sell(banknoteRate.getBanknoteSelling())
                .buy(banknoteRate.getBanknoteBuying())
                .pair(banknoteRate.getCurrencyCode())
                .unit(banknoteRate.getUnit())
                .build();
    }
}

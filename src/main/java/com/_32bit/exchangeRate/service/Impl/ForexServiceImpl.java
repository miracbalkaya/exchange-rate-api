package com._32bit.exchangeRate.service.Impl;

import com._32bit.exchangeRate.controller.dto.enums.FilterType;
import com._32bit.exchangeRate.controller.dto.request.FilterRequest;
import com._32bit.exchangeRate.controller.dto.response.CurrencyDTO;
import com._32bit.exchangeRate.controller.dto.response.DataResponse;
import com._32bit.exchangeRate.repository.ExchangeRateRepository;
import com._32bit.exchangeRate.repository.model.ExchangeRate;
import com._32bit.exchangeRate.repository.specification.ForexRateSpecification;
import com._32bit.exchangeRate.service.FilterTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ForexServiceImpl implements FilterTypeService {

    private final ExchangeRateRepository exchangeRateRepository;
    private static final String CREATED_DATE = "createDate";

    @Override
    public DataResponse filter(FilterRequest filterRequest) {

        Specification<ExchangeRate> specification = ForexRateSpecification.get(filterRequest);
        Sort sort = Sort.by(Sort.Direction.DESC, CREATED_DATE);
        List<ExchangeRate> all = exchangeRateRepository.findAll(specification, sort);

        return convertToDto(all);
    }

    @Override
    public FilterType getFilterType() {
        return FilterType.FOREX;
    }

    private DataResponse convertToDto(List<ExchangeRate> exchangeRateList) {
        DataResponse response = new DataResponse();

        response.setForex(exchangeRateList.stream().map(this::convertToDto).collect(Collectors.toList()));
        return response;
    }

    private CurrencyDTO convertToDto(ExchangeRate exchangeRate) {
        return CurrencyDTO.builder()
                .sell(exchangeRate.getForexSelling())
                .buy(exchangeRate.getForexBuying())
                .pair(exchangeRate.getCurrencyCode())
                .unit(exchangeRate.getUnit())
                .build();
    }

}

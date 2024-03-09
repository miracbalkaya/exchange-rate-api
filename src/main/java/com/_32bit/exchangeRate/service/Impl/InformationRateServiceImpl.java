package com._32bit.exchangeRate.service.Impl;

import com._32bit.exchangeRate.controller.dto.enums.FilterType;
import com._32bit.exchangeRate.controller.dto.request.FilterRequest;
import com._32bit.exchangeRate.controller.dto.response.CurrencyDTO;
import com._32bit.exchangeRate.controller.dto.response.DataResponse;
import com._32bit.exchangeRate.repository.InformationRateRepository;
import com._32bit.exchangeRate.repository.model.InformationRate;
import com._32bit.exchangeRate.repository.specification.InformationRateSpecification;
import com._32bit.exchangeRate.service.FilterTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InformationRateServiceImpl implements FilterTypeService {

    private final InformationRateRepository informationRateRepository;
    private static final String CREATED_DATE = "createDate";

    @Override
    public DataResponse filter(FilterRequest filterRequest) {
        Specification<InformationRate> specification = InformationRateSpecification.get(filterRequest);
        Sort sort = Sort.by(Sort.Direction.DESC, CREATED_DATE);
        List<InformationRate> all = informationRateRepository.findAll(specification, sort);

        return convertToDto(all);
    }

    @Override
    public FilterType getFilterType() {
        return FilterType.INFORMATION;
    }


    private DataResponse convertToDto(List<InformationRate> informationRates) {
        DataResponse response = new DataResponse();

        response.setInformation(informationRates.stream().map(this::convertToDto).collect(Collectors.toList()));
        return response;
    }

    private CurrencyDTO convertToDto(InformationRate informationRate) {
        return CurrencyDTO.builder()
                .rate(informationRate.getInformationRate())
                .pair(informationRate.getCurrencyCode())
                .unit(informationRate.getUnit())
                .build();
    }
}

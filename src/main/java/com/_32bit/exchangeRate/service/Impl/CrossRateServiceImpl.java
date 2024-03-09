package com._32bit.exchangeRate.service.Impl;

import com._32bit.exchangeRate.controller.dto.enums.FilterType;
import com._32bit.exchangeRate.controller.dto.request.FilterRequest;
import com._32bit.exchangeRate.controller.dto.response.CurrencyDTO;
import com._32bit.exchangeRate.controller.dto.response.DataResponse;
import com._32bit.exchangeRate.repository.CrossRateRepository;
import com._32bit.exchangeRate.repository.model.CrossRate;
import com._32bit.exchangeRate.repository.specification.CrossRateSpecification;
import com._32bit.exchangeRate.service.FilterTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CrossRateServiceImpl  implements FilterTypeService {

    private final CrossRateRepository crossRateRepository;

    private static final String CREATED_DATE = "createDate";

    @Override
    public DataResponse filter(FilterRequest filterRequest) {

        Specification<CrossRate> specification = CrossRateSpecification.get(filterRequest);
        Sort sort = Sort.by(Sort.Direction.DESC, CREATED_DATE);
        List<CrossRate> all = crossRateRepository.findAll(specification, sort);

        return convertToDto(all);
    }

    @Override
    public FilterType getFilterType() {
        return FilterType.CROSS;
    }

    private DataResponse convertToDto(List<CrossRate> banknoteRateList) {
        DataResponse response = new DataResponse();

        response.setCross(banknoteRateList.stream().map(this::convertToDto).collect(Collectors.toList()));
        return response;
    }

    private CurrencyDTO convertToDto(CrossRate crossRate) {
        return CurrencyDTO.builder()
                .pair(crossRate.getCurrencyCode())
                .unit(crossRate.getUnit())
                .rate(crossRate.getCrossRate())
                .build();
    }
}

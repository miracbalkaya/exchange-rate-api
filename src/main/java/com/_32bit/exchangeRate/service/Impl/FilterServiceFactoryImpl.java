package com._32bit.exchangeRate.service.Impl;

import com._32bit.exchangeRate.controller.dto.enums.FilterType;
import com._32bit.exchangeRate.controller.dto.request.FilterRequest;
import com._32bit.exchangeRate.controller.dto.response.DataResponse;
import com._32bit.exchangeRate.service.FilterService;
import com._32bit.exchangeRate.service.FilterTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FilterServiceFactoryImpl implements FilterService {

    private final Map<FilterType, FilterTypeService> filterTypeServiceMap;
    private final ExchangeRateServiceImpl exchangeRateService;

    public FilterServiceFactoryImpl(List<FilterTypeService> filterTypeServices, ExchangeRateServiceImpl exchangeRateService) {
        this.filterTypeServiceMap = filterTypeServices
                .stream()
                .collect(Collectors.toMap(FilterTypeService::getFilterType, Function.identity()));
        this.exchangeRateService = exchangeRateService;
        log.debug("Build filter service. Build Services: {}", filterTypeServiceMap);
    }

    @Override
    public DataResponse filter(FilterRequest filterRequest) {
        if (filterRequest.getType() == null) {
            log.info("All Exchange rate is returned");
            return exchangeRateService.filter(filterRequest);
        }
        return filterTypeServiceMap.get(filterRequest.getType()).filter(filterRequest);
    }
}

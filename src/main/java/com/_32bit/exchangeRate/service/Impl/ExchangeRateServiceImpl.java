package com._32bit.exchangeRate.service.Impl;

import com._32bit.exchangeRate.controller.dto.request.FilterRequest;
import com._32bit.exchangeRate.controller.dto.response.DataResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ExchangeRateServiceImpl {

    private final BanknoteRateServiceImpl banknoteRateService;
    private final ForexServiceImpl forexService;
    private final CrossRateServiceImpl crossRateService;
    private final InformationRateServiceImpl informationRateService;

    public DataResponse filter(FilterRequest filterRequest) {
        DataResponse response = new DataResponse();

        response.setInformation(informationRateService.filter(filterRequest).getInformation());
        response.setForex(forexService.filter(filterRequest).getForex());
        response.setCross(crossRateService.filter(filterRequest).getCross());
        response.setBanknote(banknoteRateService.filter(filterRequest).getBanknote());

        log.info("Data is collected and returned");
        return response;

    }

}

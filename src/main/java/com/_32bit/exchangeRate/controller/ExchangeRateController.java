package com._32bit.exchangeRate.controller;

import com._32bit.exchangeRate.controller.dto.request.FilterRequest;
import com._32bit.exchangeRate.controller.dto.response.XmlConverter;
import com._32bit.exchangeRate.service.FilterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping("/api/v1/rates")
public class ExchangeRateController {

    private final FilterService filterService;

    public ExchangeRateController(FilterService filterService) {
        this.filterService = filterService;
    }


    @GetMapping()
    public String getRates(FilterRequest filterRequest) throws JAXBException {
        return XmlConverter.convertToXml(filterService.filter(filterRequest));
    }

}



package com._32bit.exchangeRate.service;

import com._32bit.exchangeRate.controller.dto.request.FilterRequest;
import com._32bit.exchangeRate.controller.dto.response.DataResponse;

public interface FilterService {

    DataResponse filter(FilterRequest filterRequest);
}

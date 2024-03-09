package com._32bit.exchangeRate.service;

import com._32bit.exchangeRate.controller.dto.enums.FilterType;
import com._32bit.exchangeRate.controller.dto.request.FilterRequest;
import com._32bit.exchangeRate.controller.dto.response.DataResponse;

public interface FilterTypeService {

    DataResponse filter(FilterRequest filterRequest);

    FilterType getFilterType();
}

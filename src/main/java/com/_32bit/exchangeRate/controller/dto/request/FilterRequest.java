package com._32bit.exchangeRate.controller.dto.request;

import com._32bit.exchangeRate.controller.dto.enums.FilterType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Data
public class FilterRequest {

    private FilterType type;
    private LocalDateTime createdDate;
    private List<String> currencyCode;
}

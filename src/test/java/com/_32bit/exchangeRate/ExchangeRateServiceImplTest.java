package com._32bit.exchangeRate;

import com._32bit.exchangeRate.controller.dto.request.FilterRequest;
import com._32bit.exchangeRate.controller.dto.response.DataResponse;
import com._32bit.exchangeRate.service.Impl.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ExchangeRateServiceImplTest {

    @Mock
    private BanknoteRateServiceImpl banknoteRateService;
    @Mock
    private ForexServiceImpl forexService;
    @Mock
    private CrossRateServiceImpl crossRateService;
    @Mock
    private InformationRateServiceImpl informationRateService;

    @InjectMocks
    private ExchangeRateServiceImpl exchangeRateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFilter() {
        FilterRequest filterRequest = new FilterRequest();

        DataResponse mockResponse = new DataResponse();
        when(banknoteRateService.filter(filterRequest)).thenReturn(mockResponse);
        when(forexService.filter(filterRequest)).thenReturn(mockResponse);
        when(crossRateService.filter(filterRequest)).thenReturn(mockResponse);
        when(informationRateService.filter(filterRequest)).thenReturn(mockResponse);

        DataResponse result = exchangeRateService.filter(filterRequest);

        assertEquals(mockResponse.getBanknote(), result.getBanknote());
        assertEquals(mockResponse.getForex(), result.getForex());
        assertEquals(mockResponse.getCross(), result.getCross());
        assertEquals(mockResponse.getInformation(), result.getInformation());

        verify(banknoteRateService, times(1)).filter(filterRequest);
        verify(forexService, times(1)).filter(filterRequest);
        verify(crossRateService, times(1)).filter(filterRequest);
        verify(informationRateService, times(1)).filter(filterRequest);
    }
}

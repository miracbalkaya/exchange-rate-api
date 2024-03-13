package com._32bit.exchangeRate;

import com._32bit.exchangeRate.controller.dto.request.FilterRequest;
import com._32bit.exchangeRate.controller.dto.response.DataResponse;
import com._32bit.exchangeRate.repository.BanknoteRateRepository;
import com._32bit.exchangeRate.repository.model.BanknoteRate;
import com._32bit.exchangeRate.service.Impl.BanknoteRateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BanknoteRateServiceImplTest {

    @Mock
    private BanknoteRateRepository banknoteRateRepository;

    @InjectMocks
    private BanknoteRateServiceImpl banknoteRateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFilter(){
        when(banknoteRateRepository.findAll(any(Specification.class), any(Sort.class)))
                .thenReturn(Arrays.asList(createBanknoteRate("USD", 1.0, 2.0), createBanknoteRate("EUR", 1.5, 2.5)));

        FilterRequest filterRequest = new FilterRequest();

        DataResponse response = banknoteRateService.filter(filterRequest);

        assertEquals(2, response.getBanknote().size());
    }

    private BanknoteRate createBanknoteRate(String currencyCode, double buying, double selling) {
        BanknoteRate banknoteRate = new BanknoteRate();
        banknoteRate.setCurrencyCode(currencyCode);
        banknoteRate.setBanknoteBuying(buying);
        banknoteRate.setBanknoteSelling(selling);
        return banknoteRate;
    }
}

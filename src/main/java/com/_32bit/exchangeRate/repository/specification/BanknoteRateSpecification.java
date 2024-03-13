package com._32bit.exchangeRate.repository.specification;

import com._32bit.exchangeRate.controller.dto.request.FilterRequest;
import com._32bit.exchangeRate.repository.model.BanknoteRate;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Slf4j
public class BanknoteRateSpecification {

    private static final String CURRENCY_CODE = "currencyCode";
    private static final String CREATED_DATE = "createDate";

    public static Specification<BanknoteRate> get(FilterRequest filterRequest) {
        log.info("Data is checked according to currency code and create date.");
        return ((root, query, criteriaBuilder) -> {
            Predicate conjunction = criteriaBuilder.conjunction();

            if (Objects.nonNull(filterRequest.getCurrencyCode())) {
                conjunction = criteriaBuilder.and(conjunction, root.get(CURRENCY_CODE).in(filterRequest.getCurrencyCode()));
            }

            if (Objects.nonNull(filterRequest.getCreatedDate())) {
                conjunction = criteriaBuilder.and(conjunction, criteriaBuilder.greaterThanOrEqualTo(root.get(CREATED_DATE), filterRequest.getCreatedDate()));
            }

            return conjunction;
        });
    }
}

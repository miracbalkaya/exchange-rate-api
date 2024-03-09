package com._32bit.exchangeRate.repository;

import com._32bit.exchangeRate.repository.model.CrossRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CrossRateRepository extends JpaSpecificationExecutor<CrossRate>, JpaRepository<CrossRate, Integer> {
}

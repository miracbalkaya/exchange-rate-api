package com._32bit.exchangeRate.repository;

import com._32bit.exchangeRate.repository.model.BanknoteRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BanknoteRateRepository extends JpaSpecificationExecutor<BanknoteRate>, JpaRepository<BanknoteRate, Integer> {

}

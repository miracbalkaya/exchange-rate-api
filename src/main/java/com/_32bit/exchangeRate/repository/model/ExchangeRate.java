package com._32bit.exchangeRate.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exchange_rate")
public class ExchangeRate extends BaseEntity {


    @Column(name = "forex_buying")
    private double forexBuying;

    @Column(name = "forex_selling")
    private double forexSelling;

}


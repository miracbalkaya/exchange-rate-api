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
@Table(name = "banknote_rate")
public class BanknoteRate extends BaseEntity {

    @Column(name = "banknote_buying")
    private Double banknoteBuying;

    @Column(name = "banknote_selling")
    private Double banknoteSelling;


}


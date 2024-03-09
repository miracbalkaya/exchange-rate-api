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
@Table(name = "information_rate")
public class InformationRate extends BaseEntity {

    @Column(name = "information_rate")
    private double informationRate;


}


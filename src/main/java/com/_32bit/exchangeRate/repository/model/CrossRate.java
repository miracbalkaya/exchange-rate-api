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
@Table(name = "cross_rate")
public class CrossRate extends BaseEntity {


    @Column(name = "cross_rate")
    private Double crossRate;

}


package com._32bit.exchangeRate.controller.dto.response;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrencyDTO {

    @XmlAttribute(name = "Pair")
    private String pair;
    @XmlAttribute(name = "Unit")
    private String unit;
    @XmlAttribute(name = "Buy")
    private Double buy;
    @XmlAttribute(name = "Sell")
    private Double sell;
    @XmlAttribute(name = "Rate")
    private Double rate;
}


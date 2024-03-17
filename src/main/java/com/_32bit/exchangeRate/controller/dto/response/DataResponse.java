package com._32bit.exchangeRate.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.w3c.dom.ProcessingInstruction;

import javax.xml.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement(name = "Data")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"date", "forex", "banknote", "cross", "information"})
public class DataResponse {
    @XmlElementWrapper(name = "Forex")
    @XmlElement(name = "Currency")
    private List<CurrencyDTO> forex;
    @XmlElementWrapper(name = "Banknote")
    @XmlElement(name = "Currency")
    private List<CurrencyDTO> banknote;
    @XmlElementWrapper(name = "Cross")
    @XmlElement(name = "Currency")
    private List<CurrencyDTO> cross;
    @XmlElementWrapper(name = "Information")
    @XmlElement(name = "Currency")
    private List<CurrencyDTO> information;
    @XmlElement(name = "date")
    private LocalDateTime date;

}

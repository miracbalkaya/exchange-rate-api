package com._32bit.exchangeRate.controller.dto.response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
public class XmlConverter {
    public static String convertToXml(DataResponse dataResponse) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(DataResponse.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(dataResponse, stringWriter);

        return stringWriter.toString();
    }
}

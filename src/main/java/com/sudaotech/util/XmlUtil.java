package com.sudaotech.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlUtil {

    public static <T> T fromXml(String xml, Class<T> type) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(type);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        byte[] buf = xml.getBytes();

        @SuppressWarnings("unchecked")
        T obj = (T) unmarshaller.unmarshal(new ByteArrayInputStream(buf));

        return obj;
    }

    public static String toXml(Object obj) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        // jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        jaxbMarshaller.marshal(obj, os);

        return os.toString();
    }
}

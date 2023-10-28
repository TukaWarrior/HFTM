package JAXB.Aufgabe2_Marshalling;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public LocalDate unmarshal(String s) throws Exception {
        return LocalDate.parse(s, formatter);
    }

    public String marshal(LocalDate s) throws Exception {
        return formatter.format(s);
    }



}

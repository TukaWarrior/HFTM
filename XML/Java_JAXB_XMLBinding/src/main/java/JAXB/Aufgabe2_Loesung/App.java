package JAXB.Aufgabe2_Loesung;

import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDate;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class App {

    public static void main(String[] args) throws JAXBException, IOException {
        Artikel artikelA = new Artikel(1, "HFTM Fan-Bag");
        Artikel artikelB = new Artikel(2, "HFTM Cap");
        Kunde kunde = new Kunde(5, "HFTM AG", "Sportstrasse 2", "CH-2540", "Grenchen");
        Lieferschein lieferschein = new Lieferschein(5, LocalDate.of(2022, 9, 15), kunde);
        lieferschein.addPosition(new LieferscheinPosition(1, 10, artikelA));
        lieferschein.addPosition(new LieferscheinPosition(2, 1, artikelB));

        System.out.println(lieferschein);

        // JAXB-Kontext erzeugen
        JAXBContext context = JAXBContext.newInstance(Lieferschein.class);

        // XML-Datei aus Objekt
        try (FileWriter fileWriter = new FileWriter("./src/main/java/JAXB/Aufgabe2_Loesung/lieferschein.xml")) {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(lieferschein, fileWriter);
        }
    }
}
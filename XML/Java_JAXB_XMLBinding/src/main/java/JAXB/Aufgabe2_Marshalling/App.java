package JAXB.Aufgabe2_Marshalling;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class App {
    public static void main(String[] args) throws JAXBException, IOException {
        System.out.println("Hello world!");
        Artikel artikelA = new Artikel(1, "Keyboard");
        Artikel artikelB = new Artikel(2, "Mouse");
        Kunde kundeA = new Kunde(3, "Luca", "Strasse 1", "1000", "Dorf");
        Lieferschein lieferscheinA = new Lieferschein(3, LocalDate.of(2023,10,01), kundeA);
        lieferscheinA.addPosition(new LieferscheinPosition(1, 10, artikelA));
        lieferscheinA.addPosition(new LieferscheinPosition(1, 10, artikelB));

        System.out.println(lieferscheinA);

        // JAXB-Kontext erzeugen - erzeug Root Element
        JAXBContext context = JAXBContext.newInstance(Lieferschein.class);
        
        // XML-Datei aus Objekt (Marshalling)
        try (FileWriter fileWriter = new FileWriter("./src/main/java/JAXB/Aufgabe2_Marshalling/lieferscheinA.xml")) {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // Formats a oneliner into a proper XML file. 
            marshaller.marshal(lieferscheinA, fileWriter);
        }
    }
}
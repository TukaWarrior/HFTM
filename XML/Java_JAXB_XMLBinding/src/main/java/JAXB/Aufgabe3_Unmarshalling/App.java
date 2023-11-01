package JAXB.Aufgabe3_Unmarshalling;

import java.io.File;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class App {
    public static void main(String[] args) throws JAXBException, IOException {

        // JAXB-Kontext erzeugen - erzeug Root Element
        JAXBContext context = JAXBContext.newInstance(Lieferschein.class);

        // Objekt aus XML-Datei
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Lieferschein lieferscheinA = (Lieferschein) unmarshaller.unmarshal(new File("./src/main/java/JAXB/Aufgabe3_Unmarshalling/lieferscheinA.xml"));
        System.out.println(lieferscheinA);

    }
}
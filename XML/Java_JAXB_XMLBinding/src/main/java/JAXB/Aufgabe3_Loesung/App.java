package JAXB.Aufgabe3_Loesung;

import java.io.File;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class App {

    public static void main(String[] args) throws JAXBException, IOException {

        // JAXB-Kontext erzeugen
        JAXBContext context = JAXBContext.newInstance(Lieferschein.class);

        // Objekt aus XML-Datei
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Lieferschein lieferschein2 = (Lieferschein) unmarshaller.unmarshal(new File("./src/main/java/JAXB/Aufgabe3_Loesung/lieferschein.xml"));
        System.out.println(lieferschein2);
    }
}
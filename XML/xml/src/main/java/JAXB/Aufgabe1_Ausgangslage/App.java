package JAXB.Aufgabe1_Ausgangslage;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Artikel artikelA = new Artikel(1, "Keyboard");
        Artikel artikelB = new Artikel(2, "Mouse");
        Kunde kundeA = new Kunde(3, "Luca", "Strasse 1", "1000", "Dorf");
        Lieferschein lieferscheinA = new Lieferschein(3, LocalDate.of(2023,10,01), kundeA);
        lieferscheinA.addPosition(new LieferscheinPosition(1, 10, artikelA));
        lieferscheinA.addPosition(new LieferscheinPosition(1, 10, artikelB));

        System.out.println(lieferscheinA);

    }
}
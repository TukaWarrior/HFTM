package JSONB.Aufgabe01;

import java.time.LocalDate;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

public class App {

    public static void main(String[] args) {
        Artikel artikelA = new Artikel(1, "Keyboard");
        Artikel artikelB = new Artikel(2, "Mouse");
        Kunde kundeA = new Kunde(3, "Luca", "Strasse 1", "1000", "Dorf");
        Lieferschein lieferscheinA = new Lieferschein(3, LocalDate.of(2023, 10, 01), kundeA);
        lieferscheinA.addPosition(new LieferscheinPosition(1, 10, artikelA));
        lieferscheinA.addPosition(new LieferscheinPosition(2, 5, artikelB));

        System.out.println("Lieferschein-String:");
        System.out.println(lieferscheinA);

        // JsonB-Kontext erzeugen
        JsonbConfig config = new JsonbConfig().withFormatting(true);
        Jsonb jsonb = JsonbBuilder.create(config);

        // Json-String aus Objekt
        System.out.println("\nLieferschein-Json:");
        System.out.println(jsonb.toJson(lieferscheinA));
    }
}
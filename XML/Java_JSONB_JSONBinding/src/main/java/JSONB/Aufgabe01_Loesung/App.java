package JSONB.Aufgabe01_Loesung;

import java.time.LocalDate;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

public class App {

    public static void main(String[] args) {
        Artikel artikelA = new Artikel(1, "HFTM Fan-Bag");
        Artikel artikelB = new Artikel(2, "HFTM Cap");
        Kunde kunde = new Kunde(5, "HFTM AG", "Sportstrasse 2", "CH-2540", "Grenchen");
        Lieferschein lieferschein = new Lieferschein(5, LocalDate.of(2022, 9, 15), kunde);
        lieferschein.addPosition(new LieferscheinPosition(1, 10, artikelA));
        lieferschein.addPosition(new LieferscheinPosition(2, 1, artikelB));

        System.out.println("Lieferschein-String:");
        System.out.println(lieferschein);

        // JsonB-Kontext erzeugen
        JsonbConfig config = new JsonbConfig().withFormatting(true);
        Jsonb jsonb = JsonbBuilder.create(config);

        // Json-String aus Objekt
        System.out.println("\nLieferschein-Json:");
        System.out.println(jsonb.toJson(lieferschein));
    }

}

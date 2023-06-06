package ifElseEx;

import javax.lang.model.util.ElementScanner14;

public class Einkaufswagen {

    public static void main(String[] args) {
        String kundenName = "Robert Meyer";
        String artikelBeschreibung = "Shirt";

        // nummerische Variablen
        double preis = 21.99;
        int menge = 2;
        double steuer = 1.04;
        double total;

        // Total berechnen
        total = (preis * menge) * steuer;

        // deklariere eine Variable ausverkauft und initialisiere sie
        boolean ausverkauft = false;

        // Prüfe, ob die Menge > 1 ist und passe die Meldung so an, dass die
        // Mehrzahlform stimmt
        if (menge > 1) {
            artikelBeschreibung = artikelBeschreibung + "s";
        }
        String message = kundenName + " möchte " + menge + " " + artikelBeschreibung + " kaufen ";

        // Prüfe, ob der Artikel ausverkauft ist. Wenn ja, gibst du eine entsprechende
        // Meldung aus.
        // Sonst gibst du die message und das Total aus.

        if (ausverkauft) {
            System.out.println("Der Artikel ist ausverkauft");
        } else {
            System.out.println(message);
            System.out.println("Kosten mit Steuer: " + total);
        }
    }
}
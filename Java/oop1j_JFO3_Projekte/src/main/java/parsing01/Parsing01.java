package parsing01;

public class Parsing01 {
    public static void main(String[] args) {
        // Deklariere und initialisiere 3 Strings: shirtPrice, taxRate, and gibberish
        String shirtPrice = "15";
        String taxRate = "0.05";
        String gibberish = "564asdsd645f";

        // Parse shirtPrice and taxRate und gib das Total der Steuer aus
        // double shirtPrice = Double.parseDouble(taxRate);
        // System.out.println("Tax rate as int: " + taxInt);

        // double taxInt = Double.parseDouble(taxRate);
        // System.out.println("Tax rate as int: " + taxInt);

        // Versuche taxRate als int zu parsen

        // Versuche gibberish als int zu parsen
        int gibberishInt = Integer.parseInt(gibberish);
        System.out.println("Gibberish as int: " + gibberishInt);

    }

}
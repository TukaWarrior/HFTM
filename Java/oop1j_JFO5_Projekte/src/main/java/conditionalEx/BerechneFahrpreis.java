package conditionalEx;

import java.util.Scanner;

public class BerechneFahrpreis {

    public static void main(String args[]) {

        double fahrpreis;

        Scanner scn = new Scanner(System.in);
        System.out.println("Gib dein Alter ein: ");
        double alter = scn.nextDouble();

        if (alter < 11) {
            fahrpreis = 3;
        } else if (alter > 11 && alter < 65) {
            fahrpreis = 5;
        } else {
            fahrpreis = 3;
        }
        System.out.println("Der Fahrpreis beträgt CHF: " + fahrpreis);
    }
}
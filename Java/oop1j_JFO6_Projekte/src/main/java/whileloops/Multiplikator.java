package main.java.whileloops;

import java.util.Scanner;

public class Multiplikator {
    public static void main(String args[]) {

        Scanner scn = new Scanner(System.in);

        String meldung = "(Abbruch mit 0)\nGib eine neue Ganzzahl ein: ";
        System.out.print(meldung);

        long zahl = scn.nextLong();

        while ((zahl != 0) && (zahl != 1)) {
            do {
                zahl = (zahl * zahl);
                System.out.println(zahl);
            } while (zahl <= 1000);
            System.out.print(meldung);
            zahl = scn.nextLong();
        }
        scn.close();
    }
}
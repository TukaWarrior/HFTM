package conditionalEx;

import java.util.Scanner;

public class FilmSchauen {

    public static void main(String args[]) {
        System.out.print("Gib den Ticketpreis ein: \n");

        Scanner sc = new Scanner(System.in);
        double preis = sc.nextDouble();
        double bewertung = 5;
        if ((preis <= 12) && (bewertung == 5)) {
            System.out.println("Ich möchte diesen Film sehen.");
        } else {
            System.out.println("Ich möchte diesen Film nicht sehen.");
        }
    }
}
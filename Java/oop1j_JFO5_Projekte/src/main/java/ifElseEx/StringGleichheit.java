package ifElseEx;

import java.util.Scanner;

public class StringGleichheit {
    public static void main(String[] args) {
        String name = "Elvis";

        Scanner in = new Scanner(System.in);
        System.out.println("Gib dein Name ein");
        String eingabe = in.next();

        // boolean test name.equals.eingabe;
        if (name.equals(eingabe)) {
            System.out.println("Du bist der King");
        } else {
            System.out.println("Du bist nicht der King");
        }
    }
}
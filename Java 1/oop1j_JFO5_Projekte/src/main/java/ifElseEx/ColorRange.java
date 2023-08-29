package ifElseEx;

import java.util.Scanner;

public class ColorRange {

    public static void main(String args[]) {

        String color;
        double wavelength;

        Scanner sc = new Scanner(System.in);
        System.out.println("Gib die Wellenlänge in Nanometer ein: ");
        wavelength = sc.nextDouble();
        sc.close();

        if ((wavelength >= 380) && (wavelength < 450)) {
            color = "Violett";
        } else if ((wavelength >= 450) && (wavelength < 495)) {
            color = "Blau";
        } else if ((wavelength >= 495) && (wavelength < 570)) {
            color = "Grün";
        } else if ((wavelength >= 570) && (wavelength < 590)) {
            color = "Gelb";
        } else if ((wavelength >= 590) && (wavelength < 620)) {
            color = "Orange";
        } else if ((wavelength >= 620) && (wavelength < 750)) {
            color = "Rot";
        } else {
            color = "nicht im sichtbaren Spektrum";
        }

        System.out.println("Die Farbe ist " + color);
    }
}
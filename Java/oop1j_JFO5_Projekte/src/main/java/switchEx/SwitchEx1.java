package switchEx;

import java.util.Scanner;

public class SwitchEx1 {

    public static void main(String args[]) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Monat als Zahl eingeben:");
        int monat = scn.nextInt();
        String typMonat;

        switch (monat) {
            case 1:
                typMonat = "Januar";
                break;
            case 2:
                typMonat = "Februar";
                break;
            case 3:
                typMonat = "März";
                break;
            case 4:
                typMonat = "April";
                break;
            case 5:
                typMonat = "Mai";
                break;
            case 6:
                typMonat = "Juni";
                break;
            case 7:
                typMonat = "Juli";
                break;
            case 8:
                typMonat = "August";
                break;
            case 9:
                typMonat = "September";
                break;
            case 10:
                typMonat = "Oktober";
                break;
            case 11:
                typMonat = "November";
                break;
            case 12:
                typMonat = "Dezember";
                break;
            default:
                typMonat = "Ungültige Eingabe";
        }
        System.out.println(typMonat);
    }
}
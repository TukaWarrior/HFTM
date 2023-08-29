package ifElseEx;

import java.util.Scanner;

public class ChkOddEven {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int num = 0;
        System.out.println("Gib eine Zahl ein:");
        num = in.nextInt();
        if (num >= 1 && num <= 10) {
            if ((num % 2) == 0) {
                System.out.println("Die Zahl ist gerade");
            }
            if ((num % 2) != 0) {
                System.out.println("Die Zahl ist ungerade");
            }
        }
    }
}
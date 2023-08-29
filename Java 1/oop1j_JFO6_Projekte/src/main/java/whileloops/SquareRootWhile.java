package whileloops;

import java.util.Scanner;

public class SquareRootWhile {
    public static void main(String args[]) {
        System.out.print("Gib eine positive Ganzahl ein: ");
        System.out.println("(Abbruch mit -1)");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println("Wurzel: " + Math.sqrt(number));
        sc.close();
    }
}
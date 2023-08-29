package ifElseEx;

import java.util.Scanner;

public class AgeValidity {

    public static void main(String[] args) {

        int alter;

        Scanner in = new Scanner(System.in);
        System.out.println("Gib dein Alter ein");
        alter = in.nextInt();
        boolean fahrenUnterAltersgrenze = alter < 18;
        System.out.println(fahrenUnterAltersgrenze);
    }
}
package com.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter Year: ");
        System.out.println("For example 1993");
        int year = scnr.nextInt();

        if (((year % 4) == 0) & ((year % 1000) != 0)) {
            System.out.println("This is a leap year.");
        } else {

            System.out.println("This is no leap year");
        }
    }
}

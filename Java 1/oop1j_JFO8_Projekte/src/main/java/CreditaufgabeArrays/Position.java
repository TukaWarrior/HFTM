package CreditaufgabeArrays;

import java.util.Scanner;

public class Position {

    // Fields
    int nPositions;
    String[] itemDescription;
    int[] itemCount;
    double[] itemPrice;

    // Getters
    public int getnPositions() {
        return nPositions;
    }

    public String[] getItemDescription() {
        return itemDescription;
    }

    public int[] getItemCount() {
        return itemCount;
    }

    public double[] getItemPrice() {
        return itemPrice;
    }

    // Methods
    public void enterPositions() {
        // Set Position Count
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of Positionen: ");
        nPositions = sc.nextInt();

        // Initializing Array Length for Positions
        itemDescription = new String[nPositions];
        itemCount = new int[nPositions];
        itemPrice = new double[nPositions];

        // Input of Variables for each Positions
        for (int i = 0; i < nPositions; i++) {
            System.out.print("Pos. " + Integer.toString(i + 1) + " Description: ");
            itemDescription[i] = sc.next();
            System.out.print("Pos. " + Integer.toString(i + 1) + " Ammount: ");
            itemCount[i] = sc.nextInt();
            System.out.print("Pos. " + Integer.toString(i + 1) + " Unit Price: ");
            itemPrice[i] = sc.nextDouble();
        }
        sc.close();
    }
}
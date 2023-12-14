package ch.hftm;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        // Time Meassurement Start
        long startTime = System.nanoTime();

        // Beispiel-Array
        int[] numbers = { 40, 7, 59, 4, 1 };
        
        // Sortiere den Beispiel-Array!
        System.out.println(Arrays.toString(selectionSort(numbers)));

        // // Ausgabe des sortierten Arrays
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        // Time Meassurement Stop
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("\nTotal execution time: " + elapsedTime/1000 + " µs");
    }

public static int[] selectionSort(int[] numbers){
    for (int i = 0; i < numbers.length -1; i++) {
        for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[j] < numbers[i]) {
                int temp = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] = temp;
            }
        }
    }
    return numbers;
}
}
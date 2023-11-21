package ch.hftm;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] data2 = {269, 202, 516, 644, 455, 999, 637, 785, 978, 102};

        // Time Meassurement Start
        long startTime = System.nanoTime();

        // Perform bubble sort and print the results
        System.out.println("Sorting array " + Arrays.toString(data) + ": " + Arrays.toString(BubbleSortTester(data)));
        System.out.println("Sorting array " + Arrays.toString(data2) + ": " + Arrays.toString(BubbleSortTester(data2)));
        System.out.println("Sorting array " + Arrays.toString(data) + ": " + Arrays.toString(BubbleSortTester2(data)));
        System.out.println("Sorting array " + Arrays.toString(data2) + ": " + Arrays.toString(BubbleSortTester2(data2)));

        // Time Meassurement Stop
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Total execution time: " + elapsedTime/1000 + " µs");
    }


    public static int[] BubbleSortTester(int[] numbers) {
    
        for (int j = 0; j < numbers.length; j++) {
            for (int i = 0; i < numbers.length - 1; i++) {
                // if the numbers are not in order
                if (numbers[i] > numbers[i + 1]) {
                    // swap the numbers
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
        }
        return numbers;
    }


    public static int[] BubbleSortTester2(int[] numbers) {
        boolean sorted;
    
        for (int j = 0; j < numbers.length; j++) {
            sorted = true;
            for (int i = 0; i < numbers.length - 1; i++) {
                // if the numbers are not in order
                if (numbers[i] > numbers[i + 1]) {
                    // swap the numbers
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
            if (sorted) {
                break;
            }
        }
        return numbers;
    }
}
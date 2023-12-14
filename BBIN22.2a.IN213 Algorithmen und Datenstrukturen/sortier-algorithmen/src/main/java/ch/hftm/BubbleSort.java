package ch.hftm;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
        
        // int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // int[] data2 = {269, 202, 516, 644, 455, 999, 637, 785, 978, 102};
        // int[] numbers = { 40, 7, 59, 4, 1 };
        int[] numbers = generateRandomArray(100000);
        // int[] numbers = generateSortedArray(100000);
        // for (int number : numbers) {
        //     System.out.print(number + " ");
        // }

        // for (int i = 0; i < numbers.length; i++) {
        //     for (int j = 0; j < numbers.length - 1; j++) {
        //         // if the numbers are not in order
        //         if (numbers[j] > numbers[j + 1]) {
        //             // swap the numbers
        //             int temp = numbers[j];
        //             numbers[j] = numbers[j + 1];
        //             numbers[j + 1] = temp;
        //         }
        //     }
        // }
        // System.out.println(Arrays.toString(numbers));

        // Time Meassurement Start
        long startTime = System.nanoTime();

        // Perform bubble sort and print the results
        // System.out.println("Sorting array " + Arrays.toString(data) + ": " + Arrays.toString(BubbleSortTester(data)));
        // System.out.println("Sorting array " + Arrays.toString(data2) + ": " + Arrays.toString(BubbleSortTester(data2)));
        // System.out.println("Sorting array " + Arrays.toString(data) + ": " + Arrays.toString(BubbleSortTester2(data)));
        // System.out.println("Sorting array " + Arrays.toString(data2) + ": " + Arrays.toString(BubbleSortTester2(data2)));
        // System.out.println("Sorting array " + Arrays.toString(numbers) + ": " + Arrays.toString(BubbleSortTester(numbers)));
        System.out.println("Sorting array " + Arrays.toString(numbers) + ": " + Arrays.toString(BubbleSortTester2(numbers)));

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
    
        for (int i = 0; i < numbers.length; i++) {
            sorted = true;
            for (int j = 0; j < numbers.length - 1; j++) {
                // if the numbers are not in order
                if (numbers[j] > numbers[j + 1]) {
                    // swap the numbers
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
        return numbers;
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000000); // Adjust the upper bound as needed
        }

        return array;
    }

    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i + 1; // Assuming you want an array of consecutive integers starting from 1
        }

        return array;
    }

}
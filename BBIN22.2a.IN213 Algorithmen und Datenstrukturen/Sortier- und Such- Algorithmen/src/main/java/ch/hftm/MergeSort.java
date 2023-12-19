package ch.hftm;

import java.util.Random;
import java.util.stream.IntStream;

public class MergeSort {
    
    public static void main(String[] args) {

        // Create Array of Random Size 
        final int maxRandomValue = 1000;
        final int arraySize = 100;
        int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt(maxRandomValue)).limit(arraySize).toArray();
        int[] randomIntsArray2 = randomIntsArray.clone();

        // Time Meassurement Start
        long startTime = System.nanoTime();
        
        mergeSort(randomIntsArray, 0, randomIntsArray.length - 1);
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Merge-Sort execution time: " + elapsedTime/1000 + " µs");

        // Test Bubble-Sort
        BubbleSortTester(randomIntsArray2);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Bubble-Sort execution time: " + elapsedTime/1000 + " µs");
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = left + (right - left) / 2;

            // Recursively sort the first and second halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    public static void merge(int[] array, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Merge the temporary arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[], if there are any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[], if there are any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();

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

}
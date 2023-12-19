package ch.hftm;

import java.util.Arrays;

public class MergeSortGPT {
    public static void main(String[] args) {
        int[] numbers = {12, 11, 13, 5, 6, 7, 99, 55, 258, 123, 458, 756, 82, 475};
        
        System.out.println("Original array:");
        System.out.println(Arrays.toString(numbers));

        mergeSort(numbers, 0, numbers.length - 1);

        System.out.println("\nSorted array:");
        System.out.println(Arrays.toString(numbers));
    }


    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = left + (right - left) / 2;

            // Recursively sort the first and second halves
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }


    public static void merge(int[] arr, int left, int middle, int right) {
        // Sizes of the two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = arr[middle + 1 + j];
        }

        // Merge the temporary arrays

        // Initial indices of the two subarrays
        int i = 0, j = 0;

        // Initial index of the merged subarray
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[], if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[], if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
package ch.hftm;

public class CheatSheet1 {


    // Selection Sort
    public static int[] SelectionSort(int[] numbers){

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
    

    // Bubble Sort
    public static int[] BubbleSort(int[] numbers) {
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


    // Merge Sort



}
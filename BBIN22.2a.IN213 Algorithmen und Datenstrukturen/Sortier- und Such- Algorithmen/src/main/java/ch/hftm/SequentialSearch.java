package ch.hftm;

public class SequentialSearch {

    public static void main(String[] args) {
        
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target1 = 6;
        int[] data2 = {269, 202, 516, 644, 455, 999, 637, 785, 978, 102};
        int target2 = 11;

        // Time Meassurement Start
        long startTime = System.nanoTime();

        // Perform binary search and print the results
        System.out.println("Searching for " + target1 + ": " + sequentialSearch(target1, data));
        System.out.println("Searching for " + target2 + ": " + sequentialSearch(target2, data2));

        // Time Meassurement Stop
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Total execution time: " + elapsedTime/1000 + " µs");
    }

public static int sequentialSearch(int target, int[] data) {
    for (int i = 0; i < data.length; i++) {
        if (data[i] == target) {
            return i; // The target was found
        }
    }
    return -1; // The target was not found
}
}
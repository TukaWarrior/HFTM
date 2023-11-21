package ch.hftm;

public class BinarySearch {
    
    public static void main(String[] args) {
        
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] data2 = {269, 202, 516, 644, 455, 999, 637, 785, 978, 102};

        // Test cases
        int target1 = 6;
        int target2 = 11;

        // Time Meassurement Start
        long startTime = System.nanoTime();

        // Perform binary search and print the results
        System.out.println("Searching for " + target1 + ": " + binarySearchIndex(target1, data));
        System.out.println("Searching for " + target2 + ": " + binarySearchIndex(target2, data2));

        // Time Meassurement Stop
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Total execution time: " + elapsedTime/1000 + " µs");
    }

    

    public static int binarySearchIndex(int target, int[] data) {
        int low = 0;
        int high = data.length - 1;
    
        while (high >= low) {
            int middle = (low + high) / 2; // Middle index
            if (data[middle] == target) {
                return middle; // Target value was found
            }
            if (data[middle] < target) {
                low = middle + 1;
            }
            if (data[middle] > target) {
                high = middle - 1;
            }
        }
    
        return -1; // The value was not found
    }
}
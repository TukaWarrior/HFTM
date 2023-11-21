package ch.hftm;

public class SelectionSort {

    public static void main(String[] args) {

        // Time Meassurement Start
        long startTime = System.nanoTime();



        // Beispiel-Array
        int[] numbers = { 40, 7, 59, 4, 1 };
        
        // Index der kleinsten Nummer
        int indexMin = 0; 
        

        // Sortiere den Beispiel-Array!
        for (int i = 0; i < numbers.length -1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[i]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }

        // Ausgabe des sortierten Arrays
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }


        // Time Meassurement Stop
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Total execution time: " + elapsedTime/1000 + " µs");
    }
}
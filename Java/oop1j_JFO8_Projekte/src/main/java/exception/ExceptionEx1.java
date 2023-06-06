package exception;

public class ExceptionEx1 {
    public static void main(String args[]) {
        int[] nums = {3, 2, 6, 1};
        sumOfArray(nums);
    }

    public static void sumOfArray(int[] vals) {
        int total = 0;

        for (int i = 0; i < vals.length; i++) {
            int index = vals[i];
            total += vals[index];
            // total += vals[i]; // Correct code
        }
         System.out.println(total);
    }
}

import java.util.Scanner;

public class schaltjahr {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter Year: ");
        int year = scnr.nextInt();

        if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
            System.out.println("This is a leap year.");
        } else {

            System.out.println("This is no leap year");
        }
    }
}
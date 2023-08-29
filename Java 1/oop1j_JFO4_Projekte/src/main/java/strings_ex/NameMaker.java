package strings_ex;
import java.util.Scanner;

public class NameMaker {
    
    public static void main(String args[]) {
    String firstName, middleName, lastName, fullName;
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter your first name: ");
        firstName = in.next();

        System.out.println("Enter your middle name: ");
        middleName = in.next();

        System.out.println("Enter your last name: ");
        lastName = in.next();

        fullName = firstName + " " + middleName + " " + lastName;

// Alternative
        // fullName = firstName;
        // fullName += " " + middleName;
        // fullName += " " + lastName;

        System.out.println("Your full name is: " + fullName);
        in.close();
    }
}
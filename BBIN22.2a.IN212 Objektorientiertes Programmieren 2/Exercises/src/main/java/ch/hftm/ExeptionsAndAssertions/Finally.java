package ch.hftm.ExeptionsAndAssertions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Finally {

//    04
//    The "finally" part at the end of a "try-catch" section gets executed no matter if an exception occured or not.
//    This is useful for executing code that would get ignored if an error occurs.
//    Example:
//    A "FileInputStream" has to get closed using "close()". The code opens the "values.ser" file and tries to read from it, but it throws an exception because the file is empty.
//    The code would jump to the "catch" section and skip the "in.close()" code within the "try" section.
//    To still close the "FileInputStream", a "finally" section can be used.
//    In this example, a second "try-catch" block within the "finally" is required, because the "close()" method is able to throw an IOException.

    public static void main (String[] args) {

        InputStream in = null;

        try {
            in = new FileInputStream("values.ser");
            System.out.println("File open");
            int data = in.read();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        } catch (IOException e) {
            System.out.println("Problem with IO-Access!");
        } finally {
            try {
                if (in != null) in.close();
            } catch (IOException e){
                System.out.println("Failed to close file");
            }
        }
    }
}
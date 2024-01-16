package ch.hftm.ExeptionsAndAssertions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AutoClosable {

//    05
//    Whenever a class implements the Auto-closable interface (which is the case with most Stream classes),
//    the Stream gets automatically closed when an exception occurs if the ressource (the stream)
//    was initialized within the brackets () of the "try" block
//    Whenever the initialisation of the ressource was successful, it closes the stream if the "try" block was exited.

    public static void main (String[] args) {

        try (InputStream in = new FileInputStream("values.ser")){
            int data = in.read();
        } catch (IOException e) {
            System.out.println("Problem with IO-Access!");
        }
    }
}
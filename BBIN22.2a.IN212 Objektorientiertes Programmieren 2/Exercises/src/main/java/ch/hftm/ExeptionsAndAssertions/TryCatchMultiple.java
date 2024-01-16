package ch.hftm.ExeptionsAndAssertions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TryCatchMultiple {

//    03
//    "try" tries to execute the code within. If the code fails and throws an exception, it skips to the "catch" part, in which the error handling can be defined.
//    If the code within "try" executes without error, the "catch" section gets ignored.
//    Multiple "catch" sections can be included to handle different types of exceptions in distinct ways.

//    Some methods are able to throw exceptions. Using those methdos requires some sort of exception handling.
//    The methods "FileInputStream()" and "close()" require exception handling. In this code, this is accomplished by the "throws Exception" in the main method.
//    This code creates an exception, because the "missing.ser" file it tries to read doesen't exist.

    public static void main (String[] args) {
        try {
            InputStream in = new FileInputStream("missing.ser");
            System.out.println("File open");
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        } catch (IOException e) {
            System.out.println("Problem with IO-Access!");
        }
    }
}
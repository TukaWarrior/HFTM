package ch.hftm.ExeptionsAndAssertions;

import java.io.FileInputStream;
import java.io.InputStream;

public class ThrowsExeption {

//    01
//    "throws" makes that if an exception occurs, it gets passed along to the jvm, which has to handle it. If the code fails, the java virtual machine crashes.

//    Some methods are able to throw exceptions. Using those methdos requires some sort of exception handling.
//    The methods "FileInputStream()" and "close()" require exception handling. In this code, this is accomplished by the "throws Exception" in the main method.
//    This code creates an exception, because the "missing.ser" file it tries to read doesen't exist.

    public static void main (String[] args) throws Exception {

        InputStream in = new FileInputStream("missing.ser");
        System.out.println("File open");
        in.close();
    }
}
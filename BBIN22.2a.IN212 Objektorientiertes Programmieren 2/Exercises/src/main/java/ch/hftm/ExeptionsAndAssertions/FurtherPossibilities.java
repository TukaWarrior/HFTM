package ch.hftm.ExeptionsAndAssertions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class FurtherPossibilities {

//    06
//    It is possible to define multiple closable ressources within a single "try" block.
//    It is possible to catch multiple exceptions with a single "catch" block.

//    We can access the exeption instance with certain methods like "getMessage(), getClass() or getName()".
    public static <Course> void main (String[] args) {

        Course course = null;

        try (InputStream is = new FileInputStream("values.ser");
             ObjectInputStream in = new ObjectInputStream(is)){
            course = (Course) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }
}
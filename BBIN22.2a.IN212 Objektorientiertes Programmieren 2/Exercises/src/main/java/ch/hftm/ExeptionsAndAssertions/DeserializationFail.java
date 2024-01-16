package ch.hftm.ExeptionsAndAssertions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DeserializationFail {

    //    This is an exercise.
    public static void main(String[] args) {

        try (InputStream is = new FileInputStream("File.txt");) {

        } catch (FileNotFoundException e) {
            System.out.println("File not found exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Exception: " + e.getMessage());
            System.out.println(e.getClass().getName());
        }
    }
}
package exception;

import java.io.File;
import java.io.IOException;

public class CheckedExceptionBeispiel {
    public static void main(String args[]) {
        try {
            createFile("falscherOrdner/testFile.txt");
            System.out.println("Datei wurde erstellt!");
        } catch (IOException ex) {
            String errMsg = ex.getMessage();
            System.out.println(errMsg);
        }
    }

    public static void createFile(String filename) throws IOException {
        new File(filename).createNewFile();
    }
}

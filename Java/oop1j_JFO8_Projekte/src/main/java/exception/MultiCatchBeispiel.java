package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MultiCatchBeispiel {

    public int countChars(String fileName) {
        int total = 0;
        try {
            FileReader r = new FileReader(fileName);
            while (r.ready()) {
                r.read();
                total++;
            }
            r.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return total;
    }
}

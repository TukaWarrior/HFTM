package ch.hftm.RegularExpressions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Aufgabe2 {
    public static void main(String[] args) throws IOException {
        BufferedReader codedAnswers = new BufferedReader(new FileReader("src/main/java/ch/hftm/RegularExpressions/Aufgabe2keys.txt"));
        
        String line = codedAnswers.readLine();
        String solution = "";

        while (line != null) {
            // System.out.println(line);
            
            if (line.matches("[A-F]|[a-f]")){
                solution = solution + line;
                System.out.println(line);
            }
            line = codedAnswers.readLine();
        }
        System.out.println(solution);
        codedAnswers.close();
    }
}
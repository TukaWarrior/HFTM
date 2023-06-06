import java.util.Scanner;

public class DateiLeser {
    public static void main(String[] args) {
        Scanner scn = new Scanner(DateiLeser.class.getResourceAsStream("Textfile.txt"));

        while (scn.hasNextLine()) {
            String text = scn.nextLine();
            System.out.println(text);
        }
        scn.close();
    }
}
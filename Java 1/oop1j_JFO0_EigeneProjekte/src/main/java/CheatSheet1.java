package Foldername;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class CheatSheet1 {
// Method
    public static String functionName(String name) {
        System.out.println(name);
    }
// Main Method
    public static void main(String[] args) {
        functionName("Luca");
// Index, Length
        String textString = "Dies ist ein String";
        System.out.println(inputString.length());               // 19
        System.out.println(inputString.charAt(0));              // D
        System.out.println(inputString.replace("e", "E"));      // DiEs ist Ein String
        System.out.println(inputString.indexOf("E"));           // 2 Sucht das erste E
// Parsern, Type Casting
        String numberString = "11.1";
        double numberDouble = Double.parseDouble(numberString); // 11.1 Parsern
        int numberInt = Integer.parseInt(numberString);         // 11
        long numberLong = (long) numberDouble;                  // 11   Typecasting
// For Loop (Bestimmte Iterationen)
        for (int i = 0; i < 5; i++){                            // Zählt von 1 bis 4 (== != >= <= ;;)                               
            System.out.println("Iteration: " + i);
        }
// If Else 
        if (textString.equals("Dies ist ein String")){  // !textString.equals("")
            int outputInt = 1; 
        } else if (textString.equals("Dies ist String")){
            int outputInt = 2;
        } else {
            int outputInt = 0;
        }
// Do-While (ausführen, prüfen)
        do {
            numberInt += 1; 
        } while(numberInt == 15);
// While (ausführen bis)
        while (numberInt < 20){
            numberInt += 1;
        }
// Switch Case
        int numberMonat = 1;
        String nameMonat = "Januar";
        switch (numberMonat) {
            case 1:
                nameMonat = "Januar";
                break;
            default:
                nameMonat = "Ungültige Eingabe";
        }
// Eingaben
        String personName = in.next();
        int personAge = in.nextInt();
// Scanner
        Scanner sc = new Scanner(System.in);;
        personAge = scn.nextInt();
        sc.close();
// Meldung, Eingabefenster
        JOptionPane.showMessageDialog(null, "Mitteilung", "Titel", 0); 
        String inputJOptionPane = (String)JOptionPane.showInputDialog(null,"message", "title");
        // messagetype, icon, selectionvalue, initialselectionvalue, acceptableValues[0]     
// Datei Lesen
        Scanner scf = new Scanner(Filename.class.getResourceAsStream("Textfile.txt"));
        while (scf.hasNextLine()) {
            String textLine = scf.nextLine();
        }
        scf.close();
//Methode in anderem File
        Calculator calc = new Calculator();
    }
}
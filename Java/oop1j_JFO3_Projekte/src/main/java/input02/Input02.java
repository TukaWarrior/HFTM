package input02;

import javax.swing.JOptionPane;

public class Input02 {
    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null,
                "Diese Meldung ohne Eingabe wurde geändert. ",
                "Dieser Titel wurde geändert",
                0);

        
        String input1 = (String)JOptionPane.showInputDialog(null,
                "Ist dies eine Frage?",
                "Dialogtitel",
                2,
                null,
                null,
                "Gib hier nichts ein");
                System.out.println("Ausgabe input1: " +input1);
        
        String[] acceptableValues = {"Nein", "Mehr Nein", "Am meisten Nein"};
        String input2 = (String)JOptionPane.showInputDialog(null,
                "Ist dies eine Frage?",
                "Dialogtitel",
                3,
                null,
                acceptableValues,
                acceptableValues[0]);
                System.out.println("Ausgabe input2: " +input2);
                
        
    }
}
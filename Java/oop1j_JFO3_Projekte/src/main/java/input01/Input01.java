package input01;

import javax.swing.JOptionPane;

public class Input01 {
    public static void main(String[] args) {
        // Erzeuge ein JOptionPane
        // Speichere die Eingabe als String und gib die Variable aus
        String input = JOptionPane.showInputDialog("Type something:");
        System.out.println("Benutzer-Eingabe als String: " + input);

        // Parse den Input als int
        // Gib den Wert +1 aus
        int inputInteger = Integer.parseInt(input);
        System.out.println("Zahl als Integer: " + inputInteger);

        // Versuche, einen Dialog zu erzeugen,
        // den Wert nach int zu parsen und das Ablegen
        // des Werts in eine int-Variable auf einer
        // einzigen Zeile zu erledigen (nur 1 Semicolon).
        // und erhöhe den Wert um 1.
        int newInput = Integer.parseInt(JOptionPane.showInputDialog("Gib nocheinmal etwas ein: ")) + 1;
        System.out.println("Die neue Eingabe: " + newInput);

    }
}
package tip03;

public class CalculatorTest {
    public static void main(String[] args) {
        
       Calculator calc = new Calculator();
       
       // Verwende das Calculator-Objekt und übergib Parameter an berechneTotal()
       // um pro Person das richtige Total inkl. Steuer und Trinkgeld auszugeben
        calc.berechneTotal(10,"Person 1");
        calc.berechneTotal(12,"Person 2");
        calc.berechneTotal(9,"Person 3");
        calc.berechneTotal(8,"Person 4");
        calc.berechneTotal(7,"Person 5");
        calc.berechneTotal(15,"Alex");
        calc.berechneTotal(11,"Person 7");
        calc.berechneTotal(30,"Person 8");
       
       /*Das ist die Schuld pro Person ohne Steuer und Trinkgeld:
       Person 1: 10 Fr.
       Person 2: 12 Fr.
       Person 3:  9 Fr.
       Person 4:  8 Fr.
       Person 5:  7 Fr.
       Person 6: 15 Fr. (Alex)
       Person 7: 11 Fr.
       Person 8: 30 Fr.
       */
    }    
}

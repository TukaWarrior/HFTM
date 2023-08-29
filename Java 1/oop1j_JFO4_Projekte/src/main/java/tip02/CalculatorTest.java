package tip02;

public class CalculatorTest {
    public static void main(String[] args) { 
        //Instanziere ein Calculator-Objekt
        Calculator calc = new Calculator();
        
        //Greife auf Attribute und Methoden des Calculators zu
        //um für jeden Teilnehmer der Geburtstagsparty das Total zu berechnen
        calc.originalPreis = 10; //ein Attreibut ändern
        calc.berechneTotal(); //eine Methode aufrufen
        calc.originalPreis = 12;
        calc.berechneTotal();
        calc.originalPreis = 9;
        calc.berechneTotal();
        calc.originalPreis = 8;
        calc.berechneTotal();
        calc.originalPreis = 7;
        calc.berechneTotal();
        calc.originalPreis = 15;
        calc.berechneTotal();
        calc.originalPreis = 11;
        calc.berechneTotal();
        calc.originalPreis = 30;
        calc.berechneTotal();

        /* Die Totale ohne Steuer und Trinkgeld:
        Person 1: 10 Fr.
        Person 2: 12 Fr.
        Person 3: 9 Fr.
        Person 4: 8 Fr.
        Person 5: 7 Fr.
        Person 6: 15 Fr. (Alex)
        Person 7: 11 Fr.
        Person 8: 30 Fr.
        */   
    }
}

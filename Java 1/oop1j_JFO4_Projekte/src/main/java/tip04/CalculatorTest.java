package tip04;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        double totalKosten = calc.berechneTotal();
        System.out.println("Das Total ist CHF: " + totalKosten);
    }
}

//Teilaufgabe  1
//public class CalculatorTest {
//         Calculator calc = new Calculator();
//         calc.steuer = 0.05;
//         calc.trinkgeld = 0.15;
 
//         double[] preis = {10,12,9,8,7,15,11,30};
//         double totalKosten = calc.berechneTotal(preis);
//         System.out.println("Das Total ist CHF: " + totalKosten);
        
//     }    
// }

// Das ist die Schuld pro Person ohne Steuer und Trinkgeld: */
//    calc.berechneTotal(10, "Person 1");
//    calc.berechneTotal(12, "Person 2");
//    calc.berechneTotal(9, "Person 3");
//    calc.berechneTotal(8, "Person 4");
//    calc.berechneTotal(7, "Person 5");
//    calc.berechneTotal(15, "Person 6"); //Alex
//    calc.berechneTotal(11, "Person 7");
//    calc.berechneTotal(30, "Person 8"); //Brieftasche vergessen
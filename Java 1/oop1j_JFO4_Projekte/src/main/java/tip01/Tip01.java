package tip01;

public class Tip01 {
    public static void main(String[] args) {
    /*Berechne für jede Person das Total inkl. Steuer (5%) und Trinkgeld (15%)
    Dies sind die jeweiligen Schulden pro Person:
    Person 1: 10 Fr.
    Person 2: 12 Fr.
    Person 3: 9 Fr.
    Person 4: 8 Fr.
    Person 5: 7 Fr.
    Person 6: 15 Fr.
    Person 7: 11 Fr.
    Person 8: 30 Fr.
    */
        double steuer = 0.05;
        double trinkgeld = 0.15;
        double[] preis = {10,12,9,8,7,15,11,30};

        for (int i = 0; i < preis.length; i++) 
        {
            double total = preis[i] * (1+steuer+trinkgeld);
            System.out.println(total);
        }
    }
}
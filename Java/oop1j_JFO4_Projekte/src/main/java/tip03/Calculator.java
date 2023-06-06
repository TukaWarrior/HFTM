package tip03;

public class Calculator {
    public double steuer = .05;
    public double trinkgeld = .15;
    
    public void berechneTotal(double preis, String name){
        double total = preis*(1+steuer+trinkgeld);
        System.out.println(name + " muss " + total + " Fr. bezahlen");

    }
}
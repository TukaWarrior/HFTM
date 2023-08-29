package tip02;

public class Calculator {
    //Attribute
    public double steuer = 0.05;
    public double trinkgeld = 0.15;  //ändere steuer und trinkgeld für andere Totale
    public double originalPreis = 10;

    //Methoden
    public void berechneTotal(){
        //berechne das Total inkl. Steuer und Trinkgeld
        //gib den Wert aus
        double total = originalPreis*(1+steuer+trinkgeld);
        System.out.println("Total in CHF: " + total);
    }
}
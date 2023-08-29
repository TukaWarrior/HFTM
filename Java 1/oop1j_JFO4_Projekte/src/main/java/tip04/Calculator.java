package tip04;

public class Calculator {
    public double steuer = 0.05;
    public double trinkgeld = 0.15;
    public double p1 = 10;
    public double p2 = 12;
    public double p3 = 9;
    public double p4 = 8;
    public double p5 = 7;
    public double p6 = 15;
    public double p7 = 11;
    public double p8 = 30; 

    public double berechneTotal(){

        double aufschlagFaktor = 1+(steuer+trinkgeld);
        double[] mitGeld = {p1, p2, p3, p4, p5, p8};
        double aufgeteilt = (p6 + p7) / mitGeld.length;
        double total = 0;

        for (double i : mitGeld){
            total += ((i + aufgeteilt)*aufschlagFaktor);
        }
        return total; 
    }
}

//Teilaufgabe  1
// public class Calculator {
//     public double steuer = 0.05;
//     public double trinkgeld = 0.15;
    
//     public double berechneTotal(double preis[]){
//         double total = 0;
        
//         for (double num1 : preis){
//             total+= num1*(1+steuer+trinkgeld);
//         }
//     return total;
//     }
// }
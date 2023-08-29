package KontoTest;

public class Sparkonto {
    public String name;
    public double saldo;
    public double zinssatz;

    public void Auszahlen(double betrag){

        if(saldo < betrag){
            System.out.println("Saldo zu klein");
        } else if(betrag < 0){
            System.out.println("Negativer Betrag nicht möglich");
        } else {
            saldo = saldo - betrag;
            System.out.println(betrag +" CHF wurden vom Konto abgezogen.");
            System.out.println("Neuer Saldo von "+ name + " beträgt: " + saldo +" CHF.");
        }
    }

    // public double berechneZins(){
    //     double zins = saldo * zinssatz / 12;
    //     return zins;

}

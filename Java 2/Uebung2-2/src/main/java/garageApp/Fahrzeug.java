package garageApp;

public abstract class Fahrzeug {

    private int anzahlRaeder;
    private String hersteller;

    // Konstruktor
    public Fahrzeug(){
        hersteller = "HFTM";
    }

    public void setHersteller(String hersteller){
        this.hersteller = hersteller;
    }

    public String getHersteller(){
        return hersteller;
    }

    public void setAnzahlRaeder(int anzahlRaeder){
        this.anzahlRaeder = anzahlRaeder;
    }

    public int getAnzahlRaeder(){
        return anzahlRaeder;
    }

    // Instanzmethode
    public String signal(){
        return "huup";
    }

    public String toString(){
        return anzahlRaeder + " " + hersteller;
    }
}

package GarageApp;

public class Auto extends Fahrzeug{
    public Auto(){
        super();
        setAnzahlRaeder(4);
    }

    public String toString(){
        return "Typ: Auto\n" + super.toString();
    }
}

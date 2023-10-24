package GarageApp;

public class Fahrrad extends Fahrzeug{
    public Fahrrad(){
        super();
        setAnzahlRaeder(2);
    }

    public String toString(){
        return "Typ: Fahrrad\n" + super.toString();
    }

    @Override
    public String signal(){
        return "tuut";
    }
}

package Konstruktoren;

public class FahrzeugTest {

    public static void main (String[] args){
        Fahrzeug fahrzeug1 = new Fahrzeug();
        Fahrzeug fahrzeug2 = new Fahrzeug("BMW", "X5", 2021, "schwarz");

        System.out.println(fahrzeug2.marke);
        System.out.println(fahrzeug2);
    }
}

package Konstruktoren;

public class Fahrzeug {
    String marke;
    String typ;
    int jahrgang;
    String color;

    public Fahrzeug() {
    }

    public Fahrzeug(String marke, String typ, int jahrgang, String color) {
        this.marke = marke;
        this.typ = typ;
        this.jahrgang = jahrgang;
        this.color = color;
    }
}

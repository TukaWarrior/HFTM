package ch.hftm.CreditLineareListe.Aufgabe5;

public class TestLinListStack {
    public static void main(String[] args) {

        System.out.println("TEIL 0: Konstruktor + isEmpty()");
        LinListStack list = new LinListStack(5);
        System.out.println("Ist Liste leer? " + list.isEmpty());
        System.out.println("Aktueller Stack: " + list.toString());
        System.out.println();

        // Erstelle Struktur
        System.out.println("TEIL 1: Erstelle einen Integer Stack mit 10, 20 & 30 mit push()");
        list.push(10);
        list.push(20);
        list.push(30);
        System.out.println("Aktueller Stack: " + list.toString());
        System.out.println();

        // Struktur Ausgeben
        System.out.println("TEIL 2: Datenausgabe mit toString()");
        System.out.println("Aktueller Stack: " + list.toString());
        System.out.println();

        // Elemente suchen
        System.out.println("TEIL 3: Prüfe mit contains()");
        System.out.println("Enthält Liste den Wert 10? " + list.contains(10));
        System.out.println("Enthält Liste den Wert 25? " + list.contains(25));
        System.out.println("Aktueller Stack: " + list.toString());
        System.out.println();

        // Element entfernen
        System.out.println("TEIL 4: Entferne mit pop()");
        System.out.println("Entferne den obersten Wert: " + list.pop());
        System.out.println("Aktueller Stack: " + list.toString());
        System.out.println();

        System.out.println("TEIL 5: Füge 40 und 50 mit insert() hinzu");
        list.push(50);
        list.push(60);
        System.out.println("Aktueller Stack: " + list.toString());
        System.out.println();

        System.out.println("TEIL 8: Entferne alle Objekte mit clear()");
        list.clear();
        System.out.println("Aktueller Stack: " + list.toString());
        System.out.println();
    }
}
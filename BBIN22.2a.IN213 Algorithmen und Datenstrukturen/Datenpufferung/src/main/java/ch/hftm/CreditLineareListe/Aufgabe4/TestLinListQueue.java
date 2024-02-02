package ch.hftm.CreditLineareListe.Aufgabe4;

public class TestLinListQueue {
    public static void main(String[] args) {

        System.out.println("TEIL 0: Konstruktor + isEmpty()");
        LinListQueue list = new LinListQueue(5);
        System.out.println("Ist Liste leer? " + list.isEmpty());
        System.out.println("Aktuelle Queue: " + list.toString());
        System.out.println();

        // Erstelle Struktur
        System.out.println("TEIL 1: Erstelle eine Integer Queue mit 10, 20 & 30 mit insert()");
        list.insert(10);
        list.insert(20);
        list.insert(30);
        System.out.println("Aktuelle Queue: " + list.toString());
        System.out.println();

        // Struktur Ausgeben
        System.out.println("TEIL 2: Datenausgabe mit toString()");
        System.out.println("Aktuelle Queue: " + list.toString());
        System.out.println();

        // Elemente suchen
        System.out.println("TEIL 3: Prüfe mit contains()");
        System.out.println("Enthält Liste den Wert 10? " + list.contains(10));
        System.out.println("Enthält Liste den Wert 25? " + list.contains(25));
        System.out.println("Aktuelle Queue: " + list.toString());
        System.out.println();

        // Element entfernen
        System.out.println("TEIL 4: Entferne mit remove()");
        System.out.println("Entferne den am längsten eingelagerte Wert: " + list.remove());
        System.out.println("Aktuelle Queue: " + list.toString());
        System.out.println();

        System.out.println("TEIL 5: Füge 40 und 50 mit insert() hinzu");
        list.insert(50);
        list.insert(60);
        System.out.println("Aktuelle Queue: " + list.toString());
        System.out.println();

        System.out.println("TEIL 8: Entferne alle Objekte mit clear()");
        list.clear();
        System.out.println("Aktuelle Queue: " + list.toString());
        System.out.println();
    }
}
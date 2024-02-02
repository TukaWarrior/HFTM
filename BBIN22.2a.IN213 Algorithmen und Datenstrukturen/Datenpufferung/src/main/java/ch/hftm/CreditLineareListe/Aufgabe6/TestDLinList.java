package ch.hftm.CreditLineareListe.Aufgabe6;

public class TestDLinList {
    public static void main(String[] args) {

        System.out.println("TEIL 0: Konstruktor + isEmpty()");
        DLinList list = new DLinList();
        System.out.println("Ist Liste leer? " + list.isEmpty());
        System.out.println("Aktuelle DList: \n" + list.toString());
        System.out.println();

        // Erstelle Struktur
        System.out.println("TEIL 1: Erstelle eine Integer Liste mit 10, 20 & 30 mit addFirst()");
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        System.out.println("Aktuelle DList: \n" + list.toString());
        System.out.println();

        // Struktur Ausgeben
        System.out.println("TEIL 2: Datenausgabe mit toString()");
        System.out.println("Aktuelle DList: \n" + list.toString());
        System.out.println();

        // Elemente suchen
        System.out.println("TEIL 3: Prüfe mit contains()");
        System.out.println("Enthält Liste den Wert 10? " + list.contains(10));
        System.out.println("Enthält Liste den Wert 25? " + list.contains(25));
        System.out.println("Aktuelle DList: \n" + list.toString());
        System.out.println();

        System.out.println("TEIL 4: Füge 50 und 60 mit addLast() hinzu");
        list.addLast(50);
        list.addLast(60);
        System.out.println("Aktuelle DList: \n" + list.toString());
        System.out.println();

        System.out.println("TEIL 5: Entferne letztes Objekt mit removeFirst()");
        list.removeFirst();
        System.out.println("Aktuelle DList: \n" + list.toString());
        System.out.println();

        System.out.println("TEIL 6: Entferne letztes Objekt mit removeLast()");
        list.removeLast();
        System.out.println("Aktuelle DList: \n" + list.toString());
        System.out.println();

        System.out.println("TEIL 8: Entferne alle Objekte mit clear()");
        list.clear();
        System.out.println("Aktuelle DList: \n " + list.toString());
        System.out.println();
    }
}
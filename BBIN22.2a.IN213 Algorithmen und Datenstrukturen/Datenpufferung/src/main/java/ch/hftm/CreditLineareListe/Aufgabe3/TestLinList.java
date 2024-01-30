package ch.hftm.CreditLineareListe.Aufgabe3;

public class TestLinList {
    public static void main(String[] args) {

        System.out.println("TEIL 0: Konstruktor + isEmpty()");
        LinList list = new LinList();
        System.out.println("Ist Liste leer? " + list.isEmpty());
        System.out.println();

        // Erstelle Struktur
        System.out.println("TEIL 1: Erstelle eine Integer Liste mit "
                + "15, 30 & 45 mit addFirst()");
        list.addFirst(45);
        list.addFirst(30);
        list.addFirst(15);
        System.out.println();

        // Struktur Ausgeben
        System.out.println("TEIL 2: Datenausgabe mit toString()");
        System.out.println(list.toString());
        System.out.println();

        // Elemente suchen
        System.out.println("TEIL 3: Prüfe mit contains()");
        System.out.println("Enthält Liste den Wert 15? "
                + list.contains(15));
        System.out.println("Enthält Liste den Wert 25? "
                + list.contains(25));
        System.out.println();

        // Element entfernen
        System.out.println("TEIL 4: Entferne mit remove()");
        System.out.println("Entferne Wert 45: "
                + list.remove(45));
        System.out.println();

        System.out.println("TEIL 5: Füge 50 und 60 mit addLast() hinzu");
        list.addLast(50);
        list.addLast(60);
        System.out.println(list.toString());
        System.out.println();

        System.out.println("TEIL 6: Entferne erstes Objekt mit removeFirst()");
        list.removeFirst();
        System.out.println(list.toString());
        System.out.println();

        System.out.println("TEIL 7: Entferne letztes Objekt mit removeLast()");
        list.removeLast();
        System.out.println(list.toString());
        System.out.println();

        System.out.println("TEIL 8: Entferne alle Objekte mit clear()");
        list.clear();
        System.out.println(list.toString());
        System.out.println();
    }
}
package ch.hftm.CreditLineareListe.Aufgabe5;

/**
 * IStack
 * Das Interface "IStack" spezifiziert die Operationen,
 * welche zur Bewirtschaftung eines Stapelspeichers
 * benötigt werden.
 */

public interface IStack<E> {
    // lagert ein Objekt im Stack ein.
    public void push(E item);

    // entfernt das zuletzt einfügte Objekt aus dem
    // Stack und gibt es an den Aufrufer zurück.
    public E pop();

    // überprüft, ob der Stack leer (=true) ist
    // oder nicht (=false).
     public boolean isEmpty();

     // überprüft, ob der Stack voll (=true) ist oder
     // nicht (=false).
     public boolean isFull();
}
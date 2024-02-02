package ch.hftm.CreditLineareListe.Aufgabe4;

/**
 * IQueue
 * Das Interface "IQueue" spezifiziert die Operationen,
 * welche zur Bewirtschaftung einer Warteschlange
 * benötigt werden.
 */

public interface IQueue<E> {
    // lagert ein Objekt in der Oueue ein.
    public void insert(E item);

    // entfernt das am längsten eingelagerte Objekt aus
    // der Queue und gibt es an den Aufrufer zurück.
    public E remove();

    // überprüft, ob die Queue leer (=true)
    // ist oder nicht (=false).
     public boolean isEmpty();

     // überprüft, ob die Queue voll (=true) ist oder
     // nicht (=false).
     public boolean isFull();
}
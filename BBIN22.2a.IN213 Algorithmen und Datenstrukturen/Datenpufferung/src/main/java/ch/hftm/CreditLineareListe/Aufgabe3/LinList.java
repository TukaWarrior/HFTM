package ch.hftm.CreditLineareListe.Aufgabe3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinList<E> implements Iterable<E>{

//    Instance Variables
    private Node<E> root;

//    Constructors
    public LinList() {
        root = null;
    }

//    Methods
    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(E valueToFind) {
        Node<E> p = root;
        while ((p != null) && (!((Integer)p.data).equals(valueToFind))) {
            p = p.link;
        }
        if (p != null) {        // valueToFind in der Liste
            return true;
        } else {                // valueToFind nicht in der Liste
            return false;
        }
    }

    public void addFirst(E data) {
        root = new Node<>(data, root);
    }

    public void addLast(E data) {
        Node<E> newNode = new Node<>(data, null);

        if (root == null) {             // Setzt die neue Node als Root wenn die Liste leer ist.
            root = newNode;
        } else {                        // Iteriert durch die liste und findet die letzte Node
            Node<E> p = root;
            while (p.link != null) {
                p = p.link;
            }
            p.link = newNode;
        }
    }

    public E removeFirst() {
        if (root == null) {                 // Wenn die Liste leer ist
            return null;
        } else {                            // Setzt Root auf die nächste Node
            E removedData = root.data;
            root = root.link;
            return removedData;
        }
    }

    public E removeLast() {
        if (root == null) {                 // Wenn die Liste leer ist
            return null;
        } else {                            // Iteriere die Liste und finde die letzte Node
            Node<E> p = root;
            Node<E> q = null;

            while (p.link != null) {
                q = p;
                p = p.link;
            }

            if (q != null) {            // Entferne die letzte Node.
                q.link = null;
            } else {                    // Wenn q null ist, existiert nur eine Node.
                root = null;
            }
            return p.data;
        }
    }

    public boolean remove(E valueToRemove) {
        Node<E> p = root;          // Hilfsreferenz p sucht den Wert in der Liste
        Node<E> q = null;          // Hilfsreferenz q referenziert Knoten hinter p
        while ((p != null) && ((Integer)p.data != valueToRemove)) {
            q = p;
            p = p.link;
        }

        if (p != null) {        // Suchwert wurde gefunden
            if (q == null) {    // der erste Knoten ist der Gesuchte
                root = p.link;
            } else {            // ein anderer Knoten ist der Gesuchte
                q.link = p.link;
            }
            p = null;           // Knoten dem Garbage Collector zuführen
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        root = null;
    }

    @Override
    public String toString() {
        Node<E> iterator = root;                   // Hilfsreferenz iterator auf Wurzelknoten setzen
        String outputString = "";
        while(iterator != null) {               // solange iterator das Listenende nicht erreicht hat
            outputString += iterator.data + " ";
            iterator = iterator.link;           // Hilfsreferenz iterator auf nächsten Knoten setzen
        }
        return outputString;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = root;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.data;
                current = current.link;
                return data;
            }
        };
    }


    // Node Class
    class Node<E> {
//      Instance Variables
        E data;        // Storage for data
        Node<E> link;          // Pointer to next Node

//         Constructors
        Node(E data, Node<E> link) {
            this.data = data;
            this.link = link;
        }
    }
}
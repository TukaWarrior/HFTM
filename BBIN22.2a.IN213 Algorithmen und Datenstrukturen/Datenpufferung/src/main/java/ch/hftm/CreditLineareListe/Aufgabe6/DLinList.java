package ch.hftm.CreditLineareListe.Aufgabe6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLinList<E> implements Iterable<E>{

//    Instance Variables
    private DNode<E> head;
    private DNode<E> tail;

//    Constructors
    public DLinList() {
        head = null;
        tail = null;
    }

//    Methods
    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    public boolean contains(E valueToFind) {
        DNode<E> p = head;
        while ((p != null) && (!((Integer)p.data).equals(valueToFind))) {
            p = p.next;
        }
        if (p != null) {        // valueToFind in der Liste
            return true;
        } else {                // valueToFind nicht in der Liste
            return false;
        }
    }

    public void addFirst(E data) {
        DNode<E> newNode = new DNode<>(data, null, head);

        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }

        head = newNode;
    }

    public void addLast(E data) {
        DNode<E> newNode = new DNode<>(data, tail, null);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
    }

    public E removeFirst() {
        if (isEmpty()) {                 // Wenn die Liste leer ist
            return null;
        } else {                            // Setzt Root auf die nächste Node
            E removedData = head.data;
            head = head.next;

            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }

            return removedData;
        }
    }

    public E removeLast() {
        if (isEmpty()) {                 // Wenn die Liste leer ist
            return null;
        } else {                            // Iteriere die Liste und finde die letzte Node
            E removedData = tail.data;
            tail = tail.prev;

            if (tail == null) {
                head = null;
            } else {
                tail.next = null;
            }
            return removedData;
        }
    }

    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public String toString() {
        DNode<E> iteratorforward = head;                   // Hilfsreferenz iterator auf Wurzelknoten setzen
        DNode<E> iteratorbackward = tail;
        String outputString = "Head -> Tail: ";

        while(iteratorforward != null) {               // solange iterator das Listenende nicht erreicht hat
            outputString += " -> " + iteratorforward.data;
            iteratorforward = iteratorforward.next;           // Hilfsreferenz iterator auf nächsten Knoten setzen
        }
        outputString += "\nTail -> Head: ";

        while(iteratorbackward != null) {               // solange iterator das Listenende nicht erreicht hat
            outputString += " -> " + iteratorbackward.data;
            iteratorbackward = iteratorbackward.prev;           // Hilfsreferenz iterator auf nächsten Knoten setzen
        }

        return outputString;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private DNode<E> current = head;

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
                current = current.next;
                return data;
            }
        };
    }


    // Node Class
    class DNode<E> {
//      Instance Variables
        E data;        // Storage for data
        DNode<E> prev;
        DNode<E> next;

//         Constructors
        DNode(E data, DNode<E> prev, DNode next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
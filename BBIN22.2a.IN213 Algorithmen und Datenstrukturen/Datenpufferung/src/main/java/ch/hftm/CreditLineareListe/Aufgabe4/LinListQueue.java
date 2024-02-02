package ch.hftm.CreditLineareListe.Aufgabe4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinListQueue<E> implements Iterable<E>, IQueue<E>{

//    Instance Variables
    private Node<E> root;
    private int maxSize;

//    Constructors
    public LinListQueue(int maxSize) {
        root = null;
        this.maxSize = maxSize;
    }

//    Methods
    public boolean isEmpty() {
        return root == null;
    }

    public boolean isFull(){
        return size() == maxSize;
    }

    public int size(){
        int count = 0;
        Node <E> current = root;
        while (current != null) {
            count++;
            current = current.link;
        }
        return count;
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

    public void insert(E data) {
        Node<E> newNode = new Node<>(data, null);

        if (size() < maxSize) {
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
    }

    public E remove(){
        if (isEmpty()) {
            return null;
        }
        E removedData = root.data;
        root = root.link;
        return removedData;
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
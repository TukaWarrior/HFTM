package ch.hftm.CreditLineareListe.Aufgabe5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinListStack<E> implements Iterable<E>, IStack<E> {

//    Instance Variables
    private Node<E> root;
    private int maxSize;

    private int currentIdx = 0;

//    Constructors
    public LinListStack(int maxSize) {
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

    public void push(E data) {
        Node<E> newNode = new Node<>(data, root);

        if (size() < maxSize) {
            root = newNode; // Set the new node as the root, making it the top of the stack
        }
        currentIdx++;
    }

    public E pop(){
        if (isEmpty()) {
            return null;
        }
        E removedData = root.data;
        root = root.link;
        currentIdx--;
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
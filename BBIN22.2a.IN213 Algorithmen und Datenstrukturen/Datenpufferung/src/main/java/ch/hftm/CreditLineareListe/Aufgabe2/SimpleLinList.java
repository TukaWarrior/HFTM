package ch.hftm.CreditLineareListe;
public class SimpleLinList {

//    Instance Variables
    private Node root;

//    Constructors
    public SimpleLinList() {
        root = null;
    }

//    Methods
    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(int valueToFind) {
        Node p = root;
        while ((p != null) && (!((Integer)p.data).equals(valueToFind))) {
            p = p.link;
        }
        if (p != null) {        // valueToFind in der Liste
            return true;
        } else {                // valueToFind nicht in der Liste
            return false;
        }
    }

    public void addFirst(Object data) {
        root = new Node(data, root);
    }

    public void addLast(Object data) {
        Node newNode = new Node(data, null);

        if (root == null) {             // Setzt die neue Node als Root wenn die Liste leer ist.
            root = newNode;
        } else {                        // Iteriert durch die liste und findet die letzte Node
            Node p = root;
            while (p.link != null) {
                p = p.link;
            }
            p.link = newNode;
        }
    }

    public Object removeFirst() {
        if (root == null) {                 // Wenn die Liste leer ist
            return null;
        } else {                            // Setzt Root auf die nächste Node
            Object removedData = root.data;
            root = root.link;
            return removedData;
        }
    }

    public Object removeLast() {
        if (root == null) {                 // Wenn die Liste leer ist
            return null;
        } else {                            // Iteriere die Liste und finde die letzte Node
            Node p = root;
            Node q = null;

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

    public boolean remove(int valueToRemove) {
        Node p = root;          // Hilfsreferenz p sucht den Wert in der Liste
        Node q = null;          // Hilfsreferenz q referenziert Knoten hinter p
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

    @Override
    public String toString() {
        Node iterator = root;                   // Hilfsreferenz iterator auf Wurzelknoten setzen
        String outputString = "";
        while(iterator != null) {               // solange iterator das Listenende nicht erreicht hat
            outputString += iterator.data + " ";
            iterator = iterator.link;           // Hilfsreferenz iterator auf nächsten Knoten setzen
        }
        return outputString;
    }

// Node Class
    class Node {
//      Instance Variables
        Object data;        // Storage for data
        Node link;          // Pointer to next Node

//         Constructors
        Node(Object data, Node link) {
            this.data = data;
            this.link = link;
        }
    }
}
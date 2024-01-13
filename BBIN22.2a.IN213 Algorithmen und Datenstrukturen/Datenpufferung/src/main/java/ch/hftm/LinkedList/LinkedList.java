package ch.hftm.LinkedList;

public class LinkedList {

    private Node root;

    public void initializeExampleValues(Object first, Object second, Object third) {
        Node third = new LinkedList(null, 30);
        Node second = new LinkedList(third, 20);
        root = new Node(second, 10);
    }

    public void addFirst(Object data) {
        root = new Node(root, data);
    }

    public void printList(){
        Node iteratorNode = root;
        System.out.println("\nPrint my List: ");
        while (iteratorNode != null ) {
            System.out.println(" - " + iteratorNode.data);
            iteratorNode = iteratorNode.link;
        }
    }
}

package ch.hftm.LinkedList;

public class LinkedList {

    private Node root;

    public void initializeExampleValues() {
        Node third = new LinkedList(null, 30);
        Node second = new LinkedList(third, 20);
        root = new Node(second, 10);
    }

    public void addFirst(Object data) {
        root = new Node(root, data);
    }

    public voiud printList(){
        Node iteratorNode = root;
        System.out.println("\nPrint my List: ";);
        while (iteratorNode != null ) {
            System.out.println(" - " + iteratorNode  + data);


        }
    }

    public class Node{
        Node link;
        Object data;

        public Node(Node link, Object data) {
            this.link = link;
            this.data = data;
        }
    }
}

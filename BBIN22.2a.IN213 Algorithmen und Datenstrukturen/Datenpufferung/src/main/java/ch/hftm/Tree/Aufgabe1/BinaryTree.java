package ch.hftm.Tree.Aufgabe1;

public class BinaryTree<E> {

    private TreeNode<E> root;

    public BinaryTree() {
        root = null;
    }




    public class TreeNode<T> {
        T data;
        TreeNode<T> left = null;
        TreeNode<T> right = null;


        TreeNode (T data) {
            this.data = data;
        }

        public String toString() {
            return data.toString();
        }
    }
}

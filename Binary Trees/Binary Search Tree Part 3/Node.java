public class Node <T extends Comparable<T>> {

    T data;
    Node<T> left;
    Node<T> right;

    public Node() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return this.data;
    }

    public Node<T> getLeft() {
        return this.left;
    }

    public Node<T> getRight() {
        return this.right;
    }

    public void setValue(T data) {
        this.data = data;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public String toString(){
        return "" + this.data;
    }
}

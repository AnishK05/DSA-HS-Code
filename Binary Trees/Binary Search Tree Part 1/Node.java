public class Node {

    Comparable data;
    Node left;
    Node right;

    public Node() {
        data = null;
        left = null;
        right = null;
    }

    public Node(Comparable value) {
        data = value;
        left = null;
        right = null;
    }

    public Node(Comparable value, Node left, Node right) {
        data = value;
        this.left = left;
        this.right = right;
    }

    public Comparable getValue() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setValue(Comparable value) {
        data = value;
    }

    public void setLeft(Node left) {
        this.left = (Node) left;
    }

    public void setRight(Node right) {
        this.right = (Node) right;
    }
}

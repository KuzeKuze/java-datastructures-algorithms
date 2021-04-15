package kuze.datastructures.tree;

public class Node {
    private String id;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(String id) {
        this.id = id;
    }

    public Node(String id, Node left, Node right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id='" + id + '\'' +
                '}';
    }
}

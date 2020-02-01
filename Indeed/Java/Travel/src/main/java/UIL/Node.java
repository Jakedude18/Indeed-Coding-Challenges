package UIL;

public class Node {
    Node parent = null;
    int val;
    String name;

    public Node(String name, int data) {
        this.val = data;
        this.name = name;
    }


    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node addChild(String name, int data) {
        Node child = new Node(name, data);
        child.setParent(this);
        return child;
    }
}

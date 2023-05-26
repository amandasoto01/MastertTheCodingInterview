package BinaryTree;
public class BinaryNode {
    private int value;
    private BinaryNode right;
    private BinaryNode left;

    public BinaryNode(int value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }

    public int getValue() {
        return this.value;
    }

    public BinaryNode getRight() {
        return this.right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public BinaryNode getLeft() {
        return this.left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }
}

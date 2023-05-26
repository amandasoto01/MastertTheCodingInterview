package BinaryTree;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);
        tree.printTree(tree.getRoot());
        System.out.println();
        boolean node = tree.lookup(9);
        System.out.println(node);
        node = tree.lookup(12);
        System.out.println(node);
        tree.printTree(tree.getRoot());
        tree.printTreePreOrder(tree.getRoot());
        tree.printTreePostOrder(tree.getRoot());
    }
}
package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        tree.printTreeInOrder(tree.getRoot());
        // in order 1,4,6,9,15,20, 170
        // pre order 9, 4, 1, 6, 20, 15, 170
        // post order 1, 6, 4 , 15, 170, 20, 9
        tree.printTreeInOrder(tree.getRoot());
        tree.printTreePreOrder(tree.getRoot());
        tree.printTreePostOrder(tree.getRoot());
        System.out.println();
        boolean node = tree.lookup(9);
        System.out.println(node);
        node = tree.lookup(12);
        System.out.println(node);
        tree.printTreeInOrder(tree.getRoot());
        tree.printTreePreOrder(tree.getRoot());
        tree.printTreePostOrder(tree.getRoot());

        System.out.println(tree.breathFirstSearch());

        BinaryNode currentNode = tree.getRoot();
        List<Integer> list = new ArrayList<>();
        Queue<BinaryNode> queue = new LinkedList();
        queue.add(currentNode);
        System.out.println(tree.breathFirstSearchRecursive(queue, list));

    }
}
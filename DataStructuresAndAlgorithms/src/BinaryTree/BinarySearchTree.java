package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    private BinaryNode root = null;

    public BinarySearchTree() {
    }

    public BinaryNode getRoot() {
        return this.root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    public void insert(int value) {
        if (this.root == null) {
            this.root = new BinaryNode(value);
        } else {
            BinaryNode binaryNode = this.root;

            while(true) {
                while(value <= binaryNode.getValue()) {
                    if (binaryNode.getLeft() == null) {
                        binaryNode.setLeft(new BinaryNode(value));
                        return;
                    }

                    binaryNode = binaryNode.getLeft();
                }

                if (binaryNode.getRight() == null) {
                    binaryNode.setRight(new BinaryNode(value));
                    return;
                }

                binaryNode = binaryNode.getRight();
            }
        }
    }

    public boolean lookup(int value) {
        if (this.root == null) {
            return false;
        } else if (this.root.getValue() == value) {
            return true;
        } else {
            BinaryNode binaryNode = this.root;

            do {
                if (binaryNode == null) {
                    return false;
                }

                if (value > binaryNode.getValue()) {
                    binaryNode = binaryNode.getRight();
                } else {
                    binaryNode = binaryNode.getLeft();
                }
            } while(binaryNode == null || binaryNode.getValue() != value);

            return true;
        }
    }

    public boolean remove(int value) {
        if (this.root == null) {
            return false;
        } else {
            BinaryNode currentNode = this.root;
            BinaryNode parentNode = null;

            while(currentNode != null) {
                if (value < currentNode.getValue()) {
                    parentNode = currentNode;
                    currentNode = currentNode.getLeft();
                } else if (value > currentNode.getValue()) {
                    parentNode = currentNode;
                    currentNode = currentNode.getRight();
                } else if (value == currentNode.getValue()) {
                    if (currentNode.getRight() == null) {
                        if (parentNode == null) {
                            this.root = currentNode.getLeft();
                        } else if (currentNode.getValue() < parentNode.getValue()) {
                            parentNode.setLeft(currentNode.getLeft());
                        } else if (currentNode.getValue() > parentNode.getValue()) {
                            parentNode.setRight(currentNode.getLeft());
                        }
                    } else if (currentNode.getLeft() == null) {
                        if (parentNode == null) {
                            this.root = currentNode.getLeft();
                        } else {
                            currentNode.getRight().setLeft(currentNode.getLeft());
                            if (currentNode.getValue() < parentNode.getValue()) {
                                parentNode.setLeft(currentNode.getRight());
                            } else if (currentNode.getValue() > parentNode.getValue()) {
                                parentNode.setRight(currentNode.getRight());
                            }
                        }
                    } else {
                        BinaryNode leftmost = currentNode.getRight().getLeft();

                        BinaryNode leftMostParent;
                        for(leftMostParent = currentNode.getRight(); leftmost.getLeft() != null; leftmost = leftmost.getLeft()) {
                            leftMostParent = leftmost;
                        }

                        leftMostParent.setLeft(leftmost.getRight());
                        leftmost.setLeft(currentNode.getLeft());
                        leftmost.setRight(currentNode.getRight());
                        if (parentNode == null) {
                            this.root = leftmost;
                        } else if (currentNode.getValue() < parentNode.getValue()) {
                            parentNode.setLeft(leftmost);
                        } else if (currentNode.getValue() > parentNode.getValue()) {
                            parentNode.setRight(leftmost);
                        }
                    }

                    return true;
                }
            }

            return false;
        }
    }

    public List<Integer> breathFirstSearch() {
        BinaryNode currentNode = root;
        List<Integer> list = new ArrayList<>();
        Queue<BinaryNode> queue = new LinkedList();
        queue.add(currentNode);

        while(!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.println(currentNode.getValue());
            list.add(currentNode.getValue());

            if(currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }

            if(currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
        return list;
    }

    public List<Integer> breathFirstSearchRecursive(Queue<BinaryNode> queue, List<Integer> list) {

       if(queue.isEmpty()) {
           return list;
       }

       BinaryNode currentNode = queue.remove();
        list.add(currentNode.getValue());
        if(currentNode.getLeft() != null) {
            queue.add(currentNode.getLeft());
        }

        if(currentNode.getRight() != null) {
            queue.add(currentNode.getRight());
        }
        return breathFirstSearchRecursive(queue, list);
    }

    public void printTree(BinaryNode root) {
        System.out.println("In order");
        this.inOrderTraversal(root);
        System.out.println();
    }

    public void printTreePreOrder(BinaryNode root) {
        System.out.println("Pre order");
        this.preOrderTraversal(root);
        System.out.println();
    }

    public void printTreePostOrder(BinaryNode root) {
        System.out.println("Post order");
        this.postOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(BinaryNode root) {
        if (root != null) {
            this.inOrderTraversal(root.getLeft());
            System.out.print(root.getValue() + " ");
            this.inOrderTraversal(root.getRight());
        }

    }

    private void preOrderTraversal(BinaryNode root) {
        if (root != null) {
            System.out.print(root.getValue() + " ");
            this.preOrderTraversal(root.getLeft());
            this.preOrderTraversal(root.getRight());
        }

    }

    private void postOrderTraversal(BinaryNode root) {
        if (root != null) {
            this.postOrderTraversal(root.getLeft());
            this.postOrderTraversal(root.getRight());
            System.out.print(root.getValue() + " ");
        }

    }
}
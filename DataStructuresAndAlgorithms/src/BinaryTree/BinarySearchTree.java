package BinaryTree;

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
        if(root == null) {
            return false;
        }

        if(root.getValue() == value) {
            return true;
        }

        BinaryNode binaryNode = this.root;

        while(binaryNode != null) {
            if(binaryNode.getValue() == value) {
                return true;
            }

            if(value > binaryNode.getValue()) {
                binaryNode = binaryNode.getRight();
            } else {
                binaryNode = binaryNode.getLeft();
            }
        }
        return false;
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

    public void printTreeInOrder(BinaryNode root) {
        System.out.println("In order");
        this.DFSInOrderTraversal(root, new ArrayList<>());
        System.out.println();
    }

    public void printTreePreOrder(BinaryNode root) {
        System.out.println("Pre order");
        this.DFSPreOrderTraversal(root, new ArrayList<>());
        System.out.println();
    }

    public void printTreePostOrder(BinaryNode root) {
        System.out.println("Post order");
        this.DFSPostOrderTraversal(root, new ArrayList<>());
        System.out.println();
    }

    private void DFSInOrderTraversal(BinaryNode node, List<Integer> list) {
        if (node != null) {
            this.DFSInOrderTraversal(node.getLeft(), list);
            list.add(node.getValue());
            System.out.print(node.getValue() + " ");
            this.DFSInOrderTraversal(node.getRight(), list);
        }

    }

    private void DFSPreOrderTraversal(BinaryNode node, List<Integer> list) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            list.add(node.getValue());
            this.DFSPreOrderTraversal(node.getLeft(), list);
            this.DFSPreOrderTraversal(node.getRight(), list);
        }

    }

    private void DFSPostOrderTraversal(BinaryNode node, List<Integer> list) {
        if (node != null) {
            this.DFSPostOrderTraversal(node.getLeft(), list);
            this.DFSPostOrderTraversal(node.getRight(), list);
            System.out.print(node.getValue() + " ");
            list.add(node.getValue());
        }

    }
}
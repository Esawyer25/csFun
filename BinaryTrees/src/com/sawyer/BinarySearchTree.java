package com.sawyer;

import com.sun.tools.hat.internal.model.Root;

import java.lang.reflect.Array;
import java.util.Arrays;


public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(Node root){
        this.root = root;
    }

    public BinarySearchTree(){
        this.root = null;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot(){
        return root;
    }

    public String toString(){
        String root = ("the root is: " + this.getRoot().getData());
        String left = ("the left is: " + this.getRoot().getLeft().getData());
        String right = ("the right is: " + this.getRoot().getRight().getData());
        System.out.println(root);
        System.out.println(left);
        System.out.println(right);
        return root;
    }

    public void buildBalancedTree(){
        Node node1 = new Node(1);
        Node node3 = new Node (3);
        Node node2 = new Node(2, node1, node3);

        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node6 = new Node(8, node7, node13);

        Node node5 = new Node(5, node2, node6);
        this.setRoot(node5);
    }

    public void buildUnbalancedTree(){
        Node node1 = new Node(1);
        Node node3 = new Node (3);
        Node node2 = new Node(2, node1, node3);

        Node node6 = new Node(6);
        Node node5 = new Node(5, node2, node6);

        Node node13 = new Node(13);
        Node node7 = new Node(7, node5, node13);

        this.setRoot(node7);
    }

    //Search for a given integer value in the Binary Search Tree. Return true if the value is found, false otherwise.
    public boolean findNode(int num, Node focalNode) {
        System.out.println("entering with focal node: " + focalNode.getData());
        int focalData = focalNode.getData();
        // if the curent node's data == the number, return true
        if (num == focalData) {
            return true;
        } else if (num < focalData) { // if number < data, explore left
            if (focalNode.getLeft() != null) {
                return findNode(num, focalNode.getLeft());
            }
        } else {
            if (focalNode.getRight() != null) { // if number > data, explore right
                return findNode(num, focalNode.getRight());
            }
        }
        return false;
    }

    public boolean findNode(int num){
        //if you are not given a node, then the root is the focal node
        return findNode(num, root);
    }


//    Insert a given integer value in the Binary Search Tree.
    public void insertValue (int num, Node focalNode) {
        if (focalNode.getData() <= num) {
            // explore right
            if (focalNode.getRight() == null){ //insert here
                Node insert = new Node(num);
                focalNode.setRight(insert);
                System.out.println("made new node connected to the right of "+ focalNode.getData());
                return;
            } else {
                insertValue(num, focalNode.getRight());
            }
        } else {
            //explore left
            if (focalNode.getLeft() == null){ //insert here
                Node insert = new Node(num);
                focalNode.setLeft(insert);
                System.out.println("made new node connected to the left of "+ focalNode.getData());
                return;
            } else {
                insertValue(num, focalNode.getLeft());
            }
        }
    }

    public void insertValue (int num) {
    insertValue(num, root);
    }

    //    Compute the height of the Binary Search Tree.
    public int treeHeight(Node focalNode){
        if (focalNode == null) { //base case
            return 0;
        }
        int heightLeft = treeHeight(focalNode.getLeft());
        int heightRight = treeHeight(focalNode.getRight());

        if (heightLeft > heightRight){
            return heightLeft + 1;
        }
        return heightRight + 1;
    }

    public int treeHeight(){
        return treeHeight(root);
    }

//    Print values in the Binary Search Tree in pre-order.
    public void preOrder(Node focalNode){
        if(focalNode == null){
            return;
        } else {
            System.out.println(focalNode.getData());
            preOrder(focalNode.getLeft());
            preOrder(focalNode.getRight());
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    //    Print values in the Binary Search Tree in in-order.
    public void inOrder(Node focalNode){
        if(focalNode == null){
            return;
        } else {
            inOrder(focalNode.getLeft());
            System.out.println(focalNode.getData());
            inOrder(focalNode.getRight());
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    // Print values in the Binary Search Tree in post-order.
    public void postOrder(Node focalNode){
        if(focalNode == null){
            return;
        } else {
            postOrder(focalNode.getLeft());
            postOrder(focalNode.getRight());
            System.out.println(focalNode.getData());
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    



//    Print values in the Binary Search Tree in level-order. (Breadth-first traversal)
//    Delete a given value from the Binary Search Tree.

}

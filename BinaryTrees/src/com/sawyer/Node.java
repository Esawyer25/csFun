
package com.sawyer;

public class Node{
    private int data;
    private Node left;
    private Node right;

    public Node(int num, Node left, Node right) {
        this.data = num;
        this.left = left;
        this.right = right;
    }

    public Node(int num, Node left) {
        this.data = num;
        this.left = left;
        this.right = null;
    }

    public Node(int num) {
        this.data = num;
        this.left = null;
        this.right = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getData() {
        return data;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }
}
package com.sawyer;

import com.sun.tools.hat.internal.model.Root;

import java.lang.reflect.Array;
import java.util.*;


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

    // example trees
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

    //Recursively Search for a given integer value in the Binary Search Tree. Return true if the value is found, false otherwise.
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


//    Recursively Insert a given integer value in the Binary Search Tree.
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

//Given a Binary Search Tree where each node contains links to the left
//and right children and an integer value. Implement iterative solution
//to contains a particular integer value. The function returns true if the
//value is found in the BST, false otherwise.
    public boolean iterativeSearch(int number) {
        Node current = this.getRoot();
        if (current == null) {
            return false;
        }
        while (current != null) {
            if (current.getData() == number) {
                return true;
            } else if (current.getData() > number) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }

///Given a Binary Search Tree where each node contains links to the left
//and right children and an integer value. Implement a function to insert a
//new node with a given value in the binary search tree using an iterative
//algorithm.
    public void iterativeInsert(int number){
        Node current = this.getRoot();
        //if there is no nodes in the tree, make a new root.
        if (current == null){
            makeNewNode(number, 0);
            return;
        }
        Node parent = null;
        while (current != null){
            if (current.getData() == number){
                System.out.println("A node with this number is already in the tree");
                return;
            }
            if (current.getData () > number){
                parent = current;
                current = current.getLeft();
                if (current == null){
                    makeNewNode(parent, number, 1);
                }
            } else if (current.getData() < number) {
                parent = current;
                current = current.getRight();
                if (current == null){
                    makeNewNode(parent, number, 2);
                }
            }

        }
    }

    //helper function to add a new node
    public void makeNewNode(Node parent, int number, int whereParent){
        Node newNode;
        switch (whereParent){
            case 0: //root
                newNode = new Node(number);
                this.setRoot(newNode);
                return;
            case 1: //add to left
                newNode = new Node(number);
                parent.setLeft(newNode);
                return;
            case 2: // add to right
                newNode = new Node(number);
                parent.setRight(newNode);
                return;
            default:
                System.out.println("Invalid input");
                return;
        }
    }
    //overloaded helper function
    public void makeNewNode(int number, int whereParent){
        Node parent = null;
        makeNewNode(parent, number, whereParent);
    }

    // given an array list make a balance tree
    public void makeTree(ArrayList<Integer> data){
        ArrayList<Integer> order = balancedOrder(data);
        for (Integer number: order){
            iterativeInsert(number);
        }
    }

    public static final int log2(float f){
        return (int)Math.floor(Math.log(f)/Math.log(2.0));
    }
    // return numbers in an order that will build a balanced BST
    public static ArrayList<Integer> balancedOrder(ArrayList numbers){
        //if array is less than 3 long, order does not matter
        if (numbers.size() < 3){
            return numbers;
        }
        //sort array from smallest to largest
        Collections.sort(numbers);

        // make an ordered list of all indexes for which order matters
        // which is every number in a level of the tree that is complete
        // which is the greatest power of 2 that is smaller than the length of the array.
        int base2 = log2(numbers.size());
        ArrayList<Integer> orderedForBST = new ArrayList();
        for (int i = 1 ; i <= base2; i ++){
            float numerator = 1;
            float denominator = ((int) Math.pow(2,i));
            while (numerator < denominator) {
                double index = Math.ceil((numerator/denominator) * numbers.size())-1;
                orderedForBST.add((Integer) numbers.get((int) index));
                numerator += 2;
            }
        }
        //add all remaining numbers to list in any order
        for (int i = 0; i < numbers.size(); i ++) {
            if (!orderedForBST.contains(numbers.get(i))){
                orderedForBST.add((Integer) numbers.get(i));
            }
        }

        //print out ordered list for debugging
//        for (Integer num: orderedForBST){
//            System.out.println(num);
//        }
    return orderedForBST;
    }

    //Given a Binary Search Tree where each node contains links to the left
    //and right children and an integer value. Implement pre-order
    //traversal for a binary search tree using iterative approach.
    //Assume a stack implementation for containing node objects (or
    //pointer to the node) is provided.

    public void iterativePreOrder(){
        Node current = this.root;
        //if there is no root, return
        if (current == null){
            return;
        }
        // make stack
        Stack stack = new Stack();

        stack.push(current);
        while (!stack.isEmpty()){
            current = (Node) stack.pop();
            System.out.println(current.getData());
            if (current.getRight() != null) {stack.push(current.getRight());}
            if (current.getLeft() != null) {stack.push(current.getLeft());}
        }
    }

//Print all the values in the tree using the In-order traversal iteratively
    public void iterativeInOrder(){
        Node current = this.root;
        Stack stack = new Stack();
        while (!stack.isEmpty() || current != null){
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                current = (Node) stack.pop();
                System.out.println(current.getData());
                current = current.getRight();
            }
        }
    }

    //Given a Binary Search Tree where each node contains links to the left
    //and right children and an integer value. Implement a function to print
    //the integer values in the tree in postorder without using recursion. Use two stacks
    public void iterativePostOrder(){
        Node current = this.root;
        if (current == null){
            return;
        }
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        stack1.push(current);
        while (!stack1.isEmpty()){
            current = (Node) stack1.pop();
            stack2.push(current);
            if (current.getLeft() != null) {stack1.push(current.getLeft());}
            if (current.getRight() != null) {stack1.push(current.getRight());}
        }
        while (!stack2.isEmpty()){
            System.out.println(((Node) stack2.pop()).getData());
        }
    }

    //Iterative Breadth First Traversal:
    // Given a Binary Search Tree where each node contains links to the left
    //and right children and an integer value. Implement a function to print
    //the integer values in the tree in level order or breadth first approach
    //using a non-recursive approach. Feel free to use additional data
    //structure.
    public void iterativeBreadthFirstTraversal () {
        Node current = this.root;
        if (current == null) {return;}

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(current);
        while (!queue.isEmpty()){
            current = queue.remove();
            System.out.println(current.getData());
            if (current.getLeft() != null){
                queue.add(current.getLeft());
            }
            if (current.getRight()!= null) {
                queue.add(current.getRight());
            }
        }
    }

///Given a Binary Search Tree where each node contains links to the left
//and right children and an integer value. Design and author code for a
//function that returns the height of the Binary Search Tree using a
//iterative approach
    public int iterativeHeight(){
        Node current = this.root;
        int nodeCount = 1;
        int height = 0;
        if (current == null) {return height;}
        Queue<Node> queue1 = new LinkedList<Node>();
        Queue<Node> queue2 = new LinkedList<Node>();
        queue1.add(current);
        while (nodeCount >= 1){
            height ++;
            int newNodeCount = 0;

            while (!queue1.isEmpty()) {
                Node removedNode = queue1.remove();
                nodeCount--;
                if (removedNode.getLeft() != null) {
                    queue2.add(removedNode.getLeft());
                    newNodeCount++;
                }
                if (removedNode.getRight() != null) {
                    queue2.add(removedNode.getRight());
                    newNodeCount++;
                }
            }

            while (!queue2.isEmpty()){
                queue1.add(queue2.remove());
            }

            nodeCount = newNodeCount;
            System.out.printf("newNodeCount %s \n", nodeCount);
        }
        return height;
    }





    ///////////////////
    public Node iterativeSearchParent(int number){
        Node previous = null;
        Node current = this.getRoot();
        if (current == null){
            return previous;
        }

        while (current != null) {
            if (current.getData() == number){
                System.out.printf("found parent node value");
                return previous;
            }
            previous = current;
            if (current.getData() > number) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }


    public boolean checkAndDeleteLeaf(Node nodeToDelete, Node parent){
    if (nodeToDelete.getRight() == null && nodeToDelete.getLeft() == null){
        System.out.printf("deleteing leaf node value: %s \n", nodeToDelete.getData());
        if (parent.getRight() == nodeToDelete){
            parent.setRight(null);
        } else {
            parent.setLeft(null);
        }
        //nodeToDelete = null;
        return true;
        }
        return false;
    }

    public Node iterativeSearch(Node node, int number){
        if (node.getData() > number){
            return node.getLeft();
        }
        return node.getRight();
    }

    public boolean checkAndDeleteOneChild(Node parent, Node nodeToDelete){
        if (nodeToDelete.getRight() == null || nodeToDelete.getLeft() == null) {
            if (parent.getRight() == nodeToDelete) {
                if (nodeToDelete.getRight() == null && nodeToDelete.getLeft() != null) {
                    parent.setRight(nodeToDelete.getLeft());
                } else if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() != null) {
                    parent.setRight(nodeToDelete.getRight());
                }
            } else if (parent.getLeft() == nodeToDelete) {
                if (nodeToDelete.getRight() == null && nodeToDelete.getLeft() != null) {
                    parent.setLeft(nodeToDelete.getLeft());
                } else if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() != null) {
                    parent.setLeft(nodeToDelete.getRight());
                }
            }
            System.out.printf("deleteing node with one child value: %s", nodeToDelete.getData());

            return true;
        }
        return false;
    }


    public boolean succesorHasOneChild (Node parent, Node nodeToDelete){
        if (parent.getRight() == null || parent.getLeft ()== null){
            parent.setLeft(nodeToDelete.getLeft());
            parent.setRight(nodeToDelete.getRight());
//            nodeToDelete.setLeft(null);
//            nodeToDelete.setRight(null);
            nodeToDelete = null;
            return true;
        }
        return false;
    }

    public boolean succesorIsNotParent(Node parent, Node nodeToDelete) {
        if (parent.getRight() != null) {
            Node current = parent.getRight();
            while (current.getLeft() != null) {
                current = current.getLeft();
            }
            //case1: successor has a right child,
            // temp store current
            // Reset current to be connected to current.getRight's children to
            if (current.getLeft().getRight() != null) {
                Node temp = current;
                succesorHasOneChild(current, current.getRight());
                if (parent.getRight() == nodeToDelete) {
                    parent.setRight(temp);
                    temp.setRight(nodeToDelete.getRight());
                    temp.setLeft(nodeToDelete.getLeft());
                    nodeToDelete = null;
                    return true;
                }
            } else if (current.getLeft().getRight() == null) { //case 2: successor is a leaf
                Node temp = current;
                checkAndDeleteLeaf(current.getLeft(), current);
                parent.setRight(temp);
                temp.setRight(nodeToDelete.getRight());
                temp.setLeft(nodeToDelete.getLeft());
                nodeToDelete = null;
                return true;
            } else {
                System.out.println("something went wrong");
                return false;
            }
        }
        return false;
    }

    public boolean deleteMiddleNode(Node parent, Node nodeToDelete){
        if (nodeToDelete.getRight() != null && nodeToDelete.getLeft() != null){
            if (succesorHasOneChild(parent, nodeToDelete)){return true;}
            if (succesorIsNotParent(parent, nodeToDelete)){return true;}
            }
            return false;
    }

    public void delete(int number) {
        Node root = this.root;
        //Find Node's Parent
        Node parent = iterativeSearchParent(number);
        //Find Node
        Node nodeToDelete = iterativeSearch(parent, number);
        if (checkAndDeleteLeaf(nodeToDelete, parent)){ return;}
        if (checkAndDeleteOneChild(parent, nodeToDelete)){ return; }
        if (deleteMiddleNode(parent, nodeToDelete)){return;}
        System.out.println("something is very wrong");
    }

    



//    Print values in the Binary Search Tree in level-order. (Breadth-first traversal)
//    Delete a given value from the Binary Search Tree.

}

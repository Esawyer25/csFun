package com.sawyer;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        BinarySearchTree balance = new BinarySearchTree();
        balance.buildBalancedTree();
//        balance.toString();

        BinarySearchTree unbalance = new BinarySearchTree();
        unbalance.buildUnbalancedTree();
//        unbalance.toString();

//        System.out.println(balance.findNode(9));
//        //System.out.println(unbalance.findNode(6));
//
//        balance.insertValue(9);
//        System.out.println(balance.findNode(9));
//
//        System.out.println("height of tree: ");
//        System.out.println(balance.treeHeight());
//
//        balance.insertValue(8);
//        System.out.println("height of tree: ");
//        System.out.println(balance.treeHeight());

//        System.out.println("print out preOrder");
//        balance.preOrder();
//
//        System.out.println("print out inOrder");
//        balance.inOrder();

//        System.out.println("print out postOrder");
//        balance.postOrder();
//
//        System.out.println("iterativeSearch");
//        System.out.println( balance.iterativeSearch(9));
//        System.out.println( balance.iterativeSearch(99));
//
//        System.out.println("iterative insert");
        BinarySearchTree oak = new BinarySearchTree();
//        oak.iterativeInsert(10);
//        oak.preOrder();
//        oak.iterativeInsert(9);
//        oak.iterativeInsert(20);
//        oak.iterativeInsert(2);
//        oak.preOrder();

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
//        list.add(19);
//        list.add(9);
//        list.add(10);
//        list.add(15);
//        list.add(-1);
//        list.add(19);
//        list.add(16);
//        list.add(16);
//        list.add(150);
//        list.add(21);
//        list.add(22);
//        list.add(23);
//        list.add(24);
        oak.makeTree(list);
        oak.iterativeBreadthFirstTraversal();
//        System.out.println(oak.iterativeHeight());
        oak.delete(4);
        oak.iterativeBreadthFirstTraversal();
    }


}

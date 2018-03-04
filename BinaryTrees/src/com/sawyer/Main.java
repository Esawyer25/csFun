package com.sawyer;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.tools.tree.BinaryArithmeticExpression;

public class Main {

    public static void main(String[] args) {
	// write your code here

        BinarySearchTree balance = new BinarySearchTree();
        balance.buildBalancedTree();
//        balance.toString();

        BinarySearchTree unbalance = new BinarySearchTree();
        unbalance.buildUnbalancedTree();
//        unbalance.toString();

        System.out.println(balance.findNode(9));
        //System.out.println(unbalance.findNode(6));

        balance.insertValue(9);
        System.out.println(balance.findNode(9));

        System.out.println("height of tree: ");
        System.out.println(balance.treeHeight());

        balance.insertValue(8);
        System.out.println("height of tree: ");
        System.out.println(balance.treeHeight());

        System.out.println("print out preOrder");
        balance.preOrder();

        System.out.println("print out inOrder");
        balance.inOrder();

        System.out.println("print out postOrder");
        balance.postOrder();



    }
}

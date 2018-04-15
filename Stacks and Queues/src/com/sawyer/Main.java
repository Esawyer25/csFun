package com.sawyer;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
     //Implement a Stack using an array to hold integer data
       // defaults to a maz size of 10
//        StackArray stackArray = new StackArray();
//        System.out.println(String.format("The stack is empty? %b", stackArray.empty()));
//        stackArray.push(10);
//        stackArray.push(22);
//        stackArray.push(33);
//        stackArray.push(44);
//        stackArray.push(55);
//        stackArray.push(66);
//        stackArray.push(77);
//        stackArray.push(88);
//        stackArray.push(99);
//        stackArray.push(100);
//        stackArray.push(111);
//        stackArray.push(122);
//        stackArray.printStack();
//        stackArray.printStack();
//
//        System.out.println(String.format("The stack is empty? %b", stackArray.empty()));
//        System.out.println(String.format("The top of the stack is %d", stackArray.top()));
//        System.out.println(String.format("the min number in the stack is %d", stackArray.min()));
//        System.out.println(String.format("The top of the stack is %d", stackArray.top()));
//        System.out.println(String.format("the max number in the stack is %d", stackArray.max()));
//        System.out.println(String.format("The top of the stack is %d", stackArray.top()));
//        stackArray.pop();
//        System.out.println(String.format("the max number in the stack is %d", stackArray.max()));
//        System.out.println(String.format("The top of the stack is %d", stackArray.top()));
//
//    // Implement a Stack using a linked list to hold integer data
        System.out.println("---- LINKED LIST STACK ---");
        StackLinkedList stackLinkedList = new StackLinkedList();
        System.out.println(String.format("Linked list is empty? %b", stackLinkedList.empty()));
        stackLinkedList.push(10);
        stackLinkedList.push(20);
        stackLinkedList.push(30);
        stackLinkedList.push(40);
        stackLinkedList.push(5);
//        stackLinkedList.pop();
        System.out.println(String.format("Linked list is empty? %b", stackLinkedList.empty()));
        System.out.println(String.format("Linked list stack size: %d", stackLinkedList.size()));
        System.out.println(String.format("Linkedlest stack top is: %d", stackLinkedList.top()));
        System.out.println(String.format("the min is: %d", stackLinkedList.min()));
        System.out.println(String.format("the max is: %d", stackLinkedList.max()));
        stackLinkedList.print();
    // Implement a Queue using an array to hold integer data
        System.out.println("---- ARRAY QUEUE ---");
        QueueArray queueArray = new QueueArray(8);
        queueArray.enqueue( 1);
        queueArray.enqueue(2);
        queueArray.enqueue(3);
        queueArray.enqueue(4);
        queueArray.enqueue(5);
        queueArray.enqueue(6);
        queueArray.size();
        queueArray.min();
        queueArray.max();
        queueArray.front();
        queueArray.dequeue();
        queueArray.front();
        queueArray.dequeue();
        queueArray.dequeue();
        queueArray.enqueue(7);
        queueArray.enqueue(8);
        queueArray.enqueue(9);

    // Implement a Queue using a linked list to hold integer data
        System.out.println("---- LINKED LIST QUEUE ---");
        QueueLinkedList queueLinkedList = new QueueLinkedList();
        System.out.println(queueLinkedList.empty());
        queueLinkedList.enqueue(1);
        queueLinkedList.enqueue(2);
        queueLinkedList.enqueue(3);
        queueLinkedList.min();
        queueLinkedList.max();
        queueLinkedList.dequeue();
        System.out.println(queueLinkedList.empty());

    }
    
}

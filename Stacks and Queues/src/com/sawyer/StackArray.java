package com.sawyer;

import com.sun.javafx.binding.StringFormatter;

import java.util.Stack;

public class StackArray {
    private int[] stack;
    private int top = 0;

    public StackArray() {
        stack = new int[10];
        for (int i = 0; i < stack.length ; i++) {
            stack[i] = 9999;
        }
    }

//    public StackArray(int size) {
//        stack = new int[size];
//        for (int i = 0; i < size ; i++) {
//            stack[i] = 9999;
//        }
//    }

    public void push(int number) {
        if(top == stack.length){
            biggerStack();
        }
        stack[top] = number;
        top++;
    }

    public int pop() {
        try {
            int temp = stack[top - 1];
            stack[top] = 9999;
            top--;
            return temp;
        } catch (ArrayIndexOutOfBoundsException e) {
            //System.out.println("ERROR: Empty array, can not pop");
        }
        return 9999;
    }

    private void biggerStack () {
        int size = size();
        int[] newStack = new int[size*2];
        for (int i = 0; i < size; i++){
            int temp = stack[i];
            newStack[i] = temp;
        }
        stack = newStack;
        //System.out.println("making a bigger stack");
    }

    //Empty() which returns true is the data structure is empty, false otherwise
    public boolean empty() {
        return (top == 0) ? true : false;
    }

    // Size() which returns the number of items in the data structure
    public int size() {
        return top;
    }

    //Top() which returns the item that would be popped next (for Stack)
    public int top() {
        int temp = pop();
        push(temp);
        return temp;
    }

    //Min() which returns the minimum integer data value in the data structure
    public int min (){
        StackArray copyStack = new StackArray();
        int min = pop();
        copyStack.push(min);
        int size = size();
        for (int i = 0; i < size; i ++ ){
           int temp = pop();
           copyStack.push(temp);
           if (min > temp) {
               min = temp;
           }
        }
       reorder(copyStack, this);
       return min;
    }

    //Max() which returns the maximum integer data value in the data structure
    public int max(){
        StackArray copyStack = new StackArray();
        int max = pop();
        copyStack.push(max);
        int size = size();
        for (int i = 0; i < size; i ++ ){
            int temp = pop();
            copyStack.push(temp);
            if (max < temp) {
                max = temp;
            }
        }
        reorder(copyStack, this);
        return max;
    }

    //could also do this using a Queue;
    public static StackArray reorder (StackArray backwards, StackArray forwards){
        int size = backwards.size();
        for(int i = 0; i < size; i++){
            forwards.push(backwards.pop());
        }
        return forwards;
    }

    public void printStack(){
        System.out.print("PRINTING STACK: ");
        int size = size();
        for(int i = 0; i < size; i++){
            System.out.print(String.format(" %d,", stack[i]));
        }
        System.out.println();
    }
}

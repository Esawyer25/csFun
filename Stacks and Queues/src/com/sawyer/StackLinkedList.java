package com.sawyer;

import sun.awt.image.ImageWatched;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackLinkedList {
    private LinkedList<Integer> stackLinked = new LinkedList<Integer> ();
    private int end = 0;

    public void push(Integer value){
        stackLinked.add(value);
        end ++;
    }

    public Integer pop(){
        try {
            Integer temp =stackLinked.remove(end-1);
            end--;
            return temp;
        } catch (Exception e){
            System.out.println("Error: nothing left to pop");
            return 9999;
        }
    }

    //Empty() which returns true is the data structure is empty, false otherwise
    public boolean empty() {
        try {
            stackLinked.getFirst();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    // Size() which returns the number of items in the data structure
    public int size() {
        return end;
    }

    //Top() which returns the item that would be popped next (for Stack)
    public Integer top(){
        Integer temp = stackLinked.pop();
        stackLinked.push(temp);
        return temp;
    }
    //Min() which returns the minimum integer data value in the data structure

    public Integer min(){
        // could put in try catch block in case linked list is empty

        return stackLinked.stream().min(Comparator.naturalOrder()).get();
    }


    //Max() which returns the maximum integer data value in the data structure
    public Integer max(){
        return stackLinked.stream().max(Comparator.naturalOrder()).get();
    }

    public void print(){
        System.out.print("Printing out LinkedListStack: ");
        for (int i = 0; i < size(); i++){
            System.out.print(String.format(" %d,", stackLinked.get(i)));
        }
    }
}

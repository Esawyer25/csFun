package com.sawyer;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class QueueLinkedList {
    private LinkedList<Integer> queueLinkedList = new LinkedList<Integer> ();
    private int end = 0;
    public int size = 0;

    public void enqueue(Integer number){
        queueLinkedList.add(number);
        System.out.println("enqueued " + number);
        size ++;
    }

    public Integer dequeue(){
        if (empty()){
            System.out.println("Queue is empty.");
            return Integer.MIN_VALUE;
        }
        Integer temp = queueLinkedList.remove();
        System.out.println("dequeued " + temp);
        size --;
        return temp;
    }

    //Empty() which returns true is the data structure is empty, false otherwise
    // could also return (size == 0);
    public boolean empty(){
        try{ queueLinkedList.getFirst();
            return false;
        } catch (NoSuchElementException e){
            return true;
        }
    }

    // Size() which returns the number of items in the data structure
    public int size(){
        System.out.println("The size of the array is: " + size);
        return size;
    }

    //Front() which returns the item that would be dequeued next (for Queue)
    public Integer front(){
        Integer temp = queueLinkedList.getFirst();
        System.out.println("The next number to in the queue is: " + temp);
        return temp;
    }

    //Min() which returns the minimum integer data value in the data structure
    public Integer min() {
        Integer min = queueLinkedList.stream().min(Comparator.naturalOrder()).get();
        System.out.println("this is the min: " + min);
        return min;
    }

    public Integer max() {
        Integer max = queueLinkedList.stream().max(Comparator.naturalOrder()).get();
        System.out.println("this is the max: " + max);
        return max;
    }




    //Max() which returns the maximum integer data value in the data structure
}

package com.sawyer;

public class QueueArray {
    private int front, rear, size, capacity;
    //private int capacity;
    private int array[];
    // ints are added to the rear and removed from the front


    public QueueArray(int cap) {
        capacity = cap;
        size = 0;
        front = size;
        rear = capacity - 1;
        array = new int[capacity];
    }

    public boolean isFull(){
        return (capacity == size);
    }


    //Empty() which returns true is the data structure is empty, false otherwise
    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(int item) {
        if (isFull()){
            System.out.println("No more room in queue");
            return;
        }
        rear = (rear + 1) % capacity;
        array[rear] = item;
        size ++;
        System.out.println(item+ " enqueued to queue");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int item = array[front];
        front = (front + 1) % capacity;
        size --;
        System.out.println(item + " dequeued");
        return item;
    }

    //Size() which returns the number of items in the data structure
    public int size() {
        System.out.println("the size is: " + size);
        return size;
    }

    //Front() which returns the item that would be dequeued next (for Queue)
    public int front() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        System.out.println("the next int to dequeue is: " + array[front]);
        return array[front];
    }

    //Min() which returns the minimum integer data value in the data structure
    public int min(){
       int min = array[front];
       int index = (front + 1) % capacity;
       while((index != ((rear + 1) % capacity))){
           if (array[index] < min){
               min = array[index];
           }
           index = (index + 1) % capacity;
       }
       System.out.println("the min is: " + min);
       return min;
    }

    //Max() which returns the maximum integer data value in the data structure
    public int max(){
        int max = array[front];
        int index = (front + 1) % capacity;
        while(index != ((rear + 1) % capacity)){
            if (array[index] > max){
                max = array[index];
            }
            index = (index + 1) % capacity;
        }
        System.out.println("the man is: " + max);
        return max;
    }


}


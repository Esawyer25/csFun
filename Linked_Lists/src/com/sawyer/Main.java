package com.sawyer;

public class Main {

    public static void main(String[] args) {

        //creating a linked list
	    LinkedList myLinkedList = new LinkedList();

	    //Adding values
	    myLinkedList.insert(5);
        myLinkedList.insert(3);
        myLinkedList.insert(1);

        //check if a value is in a list
        System.out.println("It has a 5?");
        System.out.println(myLinkedList.search(5));
        System.out.println("It has a 70?");
        System.out.println(myLinkedList.search(70));

        //find max
        int max = myLinkedList.findMax();
        System.out.println("the max value is " + max);

        //find min
        int min = myLinkedList.findMin();
        System.out.println("the min value is " + min);

        // find length
        int length = myLinkedList.findLength();
        System.out.println("the list has "+ length +" nodes.");

        // return nth element from start
        int data = myLinkedList.find_nth_from_beginning(2);
        System.out.println("this is the data from the node at index 2 "+ data);
        data = myLinkedList.find_nth_from_beginning(5);
        System.out.println("this is the data from the node at index 5 "+ data);

        //insert an element in order
        System.out.println("this is my original list: ");
        myLinkedList.visit();

        System.out.println("Now i add a 0: ");
        myLinkedList.insert_ascending(0);
        myLinkedList.visit();

        System.out.println("Now i add a 4: ");
        myLinkedList.insert_ascending(4);
        myLinkedList.visit();

        System.out.println("Now i add an 8: ");
        myLinkedList.insert_ascending(8);
        myLinkedList.visit();

        //deleting a node
        System.out.println("Now i will delete an 8");
        myLinkedList.delete(8);
        myLinkedList.visit();

        System.out.println("Now i will try to delete a 2");
        myLinkedList.delete(2);
        myLinkedList.visit();

        System.out.println("Now i will delete a 0");
        myLinkedList.delete(0);
        myLinkedList.visit();

        //reverse the list
        System.out.println("Now i will reverse the list");
        myLinkedList.reverse();
        myLinkedList.visit();

        myLinkedList.reverse();
        myLinkedList.insert_ascending(10);
        myLinkedList.insert_ascending(11);

        // find middle number in an even length list
        System.out.println("i will try to find the middle number from this list");
        myLinkedList.visit();
        int mid = myLinkedList.find_middle_value();
        System.out.println("the middle number is: " + mid);

        // find middle number in an odd length list
        myLinkedList.insert_ascending(12);
        mid = myLinkedList.find_middle_value();
        System.out.println("the middle number is: " + mid);

        //find the nth from the end
        System.out.println("i will find the 2nd from the end");
        int nth = myLinkedList.find_nth_from_end(2);
        System.out.println(nth);
        System.out.println("i do not work for invalid input");
        nth = myLinkedList.find_nth_from_end(-9);
        System.out.println(nth);
        nth = myLinkedList.find_nth_from_end(9);
        System.out.println(nth);


        // test for loops
        System.out.println("i will test if this linear linked list is a loop");
        System.out.println(myLinkedList.hasCycle());

        System.out.println("now i will test if a looped list has a loop");
        myLinkedList.createCycle();
        System.out.println(myLinkedList.hasCycle());



    }


}

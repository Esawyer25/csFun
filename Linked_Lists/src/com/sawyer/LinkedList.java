package com.sawyer;

public class LinkedList {

    private Node head = null;

    public void setHead(Node head) {
        this.head = head;
    }

    public void insert(int value) {
        // method to add a new node with the specific data value in the linked list
        // add to beginning of list
        Node newNode = new Node();
        newNode.setData(value);
        newNode.setNext(head);
        this.setHead(newNode);
    }

    public boolean search(int value) {
        // method to find if the linked list contains a node with specified value
        // returns true if found, false otherwise
        Node current = this.head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int findMax() {
        // method to return the max value in the linked list
        // returns the data value and not the node
        Node current = this.head;
        if (current == null) {
            return -1;
        }
        // is there a way to return null instead of -1?
        int max = current.data;
        while (current != null) {
            max = (max < current.data) ? current.data : max;
            current = current.next;
        }
        return max;
    }

    public int findMin() {
        // method to return the min value in the linked list
        // returns the data value and not the node
        Node current = this.head;
        if (current == null) {
            return -1;
        }
        int min = current.data;
        while (current != null) {
            min = (min > current.data) ? current.data : min;
            current = current.next;
        }
        return min;
    }

    public int findLength() {
        // method that returns the length of the singly linked list
        Node current = this.head;
        int length = 0;
        while (current != null) {
            length ++;
            current = current.next;
        }
        return length;
    }

    public int find_nth_from_beginning(int value) {
        // method to return the value of the nth element from the beginning
        // assume indexing starts at 0 while counting to n
        Node current = this.head;
        //if list has no nodes
        if (current == null){
            return -1;
        }
        int i = 0;
        while (current != null) {
            //when index is found
            if (i == value) {
                return current.data;
            }
            i++;
            current = current.next;
        }
        //if index is not found
        return -1;
    }

    public void insert_ascending(int value) {
        // method to insert a new node with specific data value, assuming the linked
        // list is sorted in ascending order

        // if the new node is the head, just add the node
        Node current = this.head;
        if ((current == null) || (current.data > value)){
            this.insert(value);
            return;
        }

        // if adding node in middle
        Node newNode = new Node();
        newNode.setData(value);
        Node previous = current;
        while (current != null) {
            current = current.next;
            if (current.data > value){
                newNode.setNext(current);
                previous.setNext(newNode);
                return;
            }
            // if adding at the end
            else if (current.next == null){
                newNode.setNext(current.next);
                current.setNext(newNode);
                return;
            }
            previous = current;
        }
    }

    public void visit() {
        // method to print all the values in the linked list
        Node current = this.head;

        while (current!=null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void delete(int value) {
        // method to delete the first node found with specified value
        // if list is 0 nodes long just return
        Node current = this.head;
        if (current == null) {
            return;
        }

        //if first node is the node to be deleted move head, node is deleted by GC automatically?
        if (current.data == value) {
            this.head = current.next;
        }

        //if a middle node is the node to be deleted reset previous.next to equal current.next
        Node previous = current;
        current = current.next;
        while (current != null) {
            System.out.println("current data is "+ current.data);
            if (current.data == value) {
                previous.setNext(current.next);
                return;
            }
            previous = current;
            current = current.next;
        }
        // if there is no node with that value do nothing
        return;
    }

    public void reverse() {
        // method to reverse the singly linked list
        //note: the nodes should be moved and not just the values in the nodes

        Node current = this.head;
        // if the list is 0 or 1 nodes long do nothing
        if ((current == null)|| (current.next == null) ) {
            return;
        }

        // if list is 2 nodes or longer first initialize
        Node previous = current;
        current = current.next;
        Node next = current.next;

        previous.setNext(null);
        current.setNext(previous);

        previous = current;
        current = next;
        next = next.next;
        current.setNext(previous);

        // then loop through list until end
        while (next != null){ ;
            previous = current;
            current = next;
            next = next.next;
            current.setNext(previous);
        }

        //then reset head
        this.head = current;
        return;
    }

    public int find_middle_value() {
        //returns the value at the middle element in the singly linked list.
        // for lengths that are an even number, rounds down
        Node fast = this.head;
        //if list is 0 long do nothing
        if (fast == null) {
            return -1;
        }

        Node slow = fast;
        fast = fast.next;
        //if list is 1 or 2 long return the first node
        if ((fast == null)|| (fast.next == null)){
            return slow.data;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
            if (fast.next == null){
                return slow.data;
            }
            fast = fast.next;
        }
        return slow.data;

    }

    public int find_nth_from_end(int value) {
        //find the nth node from the end and return its value
        //assume indexing starts at 0 while counting to n

        Node fast = this.head;
        // if the list is 0 nodes long return -1
        if (fast == null) {
            return -1;
        }
        // if the value is not valid return -1
        if (value < 0) {
            return -1;
        }

        int index = 0;
        // see if the list is at least value long
        while ((fast.next != null) && (index <= value)) {
            fast = fast.next;
            index++;
        }
        // if the list is shorter than the value return -1
        if (fast.next == null){
            return -1;
        }
        // if the list is longer than the value incriment fast and slow together
        Node slow = this.head;
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;

    }

    public boolean hasCycle() {
        //checks if the linked list has a cycle. A cycle exists if any node in the
        //linked list links to a node already visited.
        //returns true if a cycle is found, false otherwise.
        Node fast = this.head;
        // if the list is 0 or 1 nodes long return -1
        if ((fast == null) || (fast.next == null)) {
            return false;
        }

        Node slow = this.head;

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
            }
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    public void createCycle() {
        //Creates a cycle in the linked list for testing purposes
        //probably should vary where it links up to.
        //Assumes the linked list has at least one node
        Node current = this.head;
        // do nothing if list is 0 nodes long
        if (head == null){
            return;
        }

        //go to last node
        while (current.next != null){
            current = current.next;
        }
        //make the last node link to the first node
        current.next = this.head;
    }




}

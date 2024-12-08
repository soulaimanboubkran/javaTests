package algos.list;

import java.util.NoSuchElementException;
public class DoublyLinkedList {
    
    private Node head;
    private Node tail;
    private  int length;

    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;

        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }
    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void insertLast(int val){
        Node newNode = new Node(val);

        if(this.length == 0){
            head = newNode;
        }else{
            tail.next = newNode; 
            newNode.prev = tail;
        }
   
        tail = newNode;
        length++;
    }
    public void insertFirst(int value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
           tail = newNode;
        } else {
           head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
     }

     public void displayForward() {
        if (head == null) {
           return;
        }
  
        Node temp = head;
        while (temp != null) {
           System.out.print(temp.data + " --> ");
           temp = temp.next;
        }
        System.out.println("null");
     }
  
     public void displayBackward() {
        if (head == null) {
           return;
        }
  
        Node temp = tail;
        while (temp != null) {
           System.out.print(temp.data + " --> ");
           temp = temp.prev;
        }
        System.out.println("null");
     }
     public Node deleteFirst() {
        if (head == null) {
           throw new NoSuchElementException();
        }
  
        Node temp = head;
        if (head == tail) {
           tail = null;
        } else {
           head.next.prev = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
     }
     public Node deleteLast() {
        if (this.length == 0) {
           throw new NoSuchElementException();
        }
  
        Node temp = tail;
        if (head == tail) {
           head = null;
        } else {
           tail.prev.next = null;
        }
        tail = tail.prev;
        temp.prev = null;
        length--;
        return temp;
     }
  
}

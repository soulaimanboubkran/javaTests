package algos.list;

import java.lang.classfile.components.ClassPrinter.ListNode;

public class CircularLinkedList {
    private Node last;
    private int length;
 
    private class Node {
       private Node next;
       private int data;
 
       public Node(int data) {
          this.data = data;
       }
    }
 
    public CircularLinkedList() {
       last = null;
       length = 0;
    }
    public int length() {
        return length;
     }
  
     public boolean isEmpty() {
        return length == 0;
     }
  public void display() {
      if (last == null) {
         return;
      }

      Node first = last.next;
      while (first != last) {
         System.out.print(first.data + " --> ");
         first = first.next;
      }
      System.out.println(first.data);
   }

   public void insertFirst(int data){
    Node temp = new Node(data);

    if(last == null){
        // If the list is empty, point the new node to itself and update the last pointer
        temp.next = temp;
        last = temp;
    }else{
      // Assign the new node to point to the first node in the list
      temp.next = last.next;
      // Update the last node to point to the new first node
      last.next = temp;
    }
    length++;
   }
   public void insertLast(int data) {
    Node temp = new Node(data);
    if (last == null) {
       last = temp;
       last.next = last;
    } else {
       temp.next = last.next;
       last.next = temp;
       last = temp;
    }
    length++;
 }

 public void deleteFirst(){
   if (isEmpty()) {
      return;
   }
   Node temp = last.next;
   if(last.next == last){
      last = null;
   }else{
      last.next = temp.next;
   }
   temp.next = null;
   length--;
 }
}

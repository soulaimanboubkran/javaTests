package algos.stack.List;

import java.util.EmptyStackException;
public class Stack {
    private Node top;
    private int length;
    private class  Node {
     private int data;
     private Node next;

     public Node(int data){
        this.data = data;
        this.next = null;
     }

        
    }

    public Stack(){
        top = null;
        length = 0;
    }
    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }
    public void push(int data) {
        Node temp = new Node(data); // Create a new node with the given data.
        temp.next = top;           // Set the new node's `next` reference to point to the current top of the stack.
        top = temp;                // Update the `top` of the stack to be the new node.
        length++;                  // Increment the length of the stack.
    }
    
    public int pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
         } 
         int res = top.data;
         top = top.next;
         length--;
         return res;
    }

    public int peek(){
        if (isEmpty()) {
            throw new EmptyStackException();
         }
         return top.data;
    }

}

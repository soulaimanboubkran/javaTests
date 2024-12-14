package algos.stack.List;

import java.util.EmptyStackException;

public class Stack<T> {
    private Node<T> top; // Top of the stack
    private int length;  // Length of the stack

    // Inner class for a node
   
    private class Node<T> {
        private T data;  // Data stored in the node
        private Node<T> next; // Reference to the next node

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor for the Stack
    public Stack() {
        top = null;
        length = 0;
    }

    // Return the length of the stack
    public int length() {
        return length;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return length == 0;
    }

    // Push an element onto the stack
    public void push(T data) {
        Node<T> temp = new Node<>(data); // Create a new node with the given data
        temp.next = top;                 // Link the new node to the current top
        top = temp;                      // Update the top of the stack
        length++;                        // Increment the length of the stack
    }

    // Pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throw exception if stack is empty
        }
        T result = top.data;  // Get the data from the top node
        top = top.next;       // Move the top pointer to the next node
        length--;             // Decrement the length of the stack
        return result;        // Return the popped data
    }

    // Peek at the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throw exception if stack is empty
        }
        return top.data; // Return the data of the top node
    }
}

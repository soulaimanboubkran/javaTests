package algos.LeetCode;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LinkedList {
    
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static class Result {

        // Insert node at specific position
        public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
            SinglyLinkedListNode newNode  = new SinglyLinkedListNode(data);
            if(llist == null) {
                return newNode;
            }

            if(position == 0) {
                newNode.next = llist;
                return newNode;
            } else {
                SinglyLinkedListNode current = llist;
                for(int i = 0; i < position - 1 && current != null; i++) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }

            return llist;
        }

        // Delete node at specific position
        public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
            if (llist == null) {
                return null;
            }

            if (position == 0) {
                return llist.next;
            }

            SinglyLinkedListNode current = llist;
            for (int i = 0; i < position - 1 && current.next != null; i++) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
            }

            return llist;
        }

        // Reverse the linked list and print in reverse order
        public static void reversePrint(SinglyLinkedListNode llist) {
            SinglyLinkedListNode current = llist;
            SinglyLinkedListNode next = null;
            SinglyLinkedListNode prev = null;

            // Reverse the list
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            // Now print the reversed list
            SinglyLinkedListNode reversedHead = prev;
            SinglyLinkedListNode printCurrent = reversedHead;
            while (printCurrent != null) {
                System.out.println(printCurrent.data);
                printCurrent = printCurrent.next;
            }
        }
    }

    // Method to print the list in original order
    public static void printSinglyLinkedList(SinglyLinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while(head1 != null && head2 != null){
            if(head1.data != head2.data){
                return false;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        if(head1 == null && head2 == null){
            return true;
        } else {
            return false;
        }

        

    }
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode merged  = new SinglyLinkedListNode(0);
        SinglyLinkedListNode current = merged;

        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                current.next = head1;
                head1 = head1.next;
            }else{
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        } else if (head2 != null) {
            current.next = head2;
        }
        return merged.next;

    }
    // we set tow pointers front and back to the head of the list we increment the front by the position until it gets there 
    //and then we start incrementing the back pointer until the front pointer reaches the end of the list sow the back pointer will be at the position from the tail
    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // Write your code here
        SinglyLinkedListNode front = llist;
        SinglyLinkedListNode back = llist;

        for(int i = 0 ; i < positionFromTail;i++){
            if (front != null) {
                front = front.next;
            }
        }

        while(front != null && front.next != null){
            front = front.next;
            back = back.next;
        }
        return back.data;
    }
    //remove duplicates from a sorted linked list
    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
        // Write your code here
            if(llist == null){
                return llist;
            }
            SinglyLinkedListNode current = llist;
            while(current != null && current.next != null){
                if(current.data == current.next.data){
                    current.next = current.next.next;
                  
                }else{
                    current = current.next;  
                }
                
            }
            return llist;
            
        }
    
    //Floyd's Cycle-Finding Algorithm 
    static boolean hasCycle(SinglyLinkedListNode head) {
        if(head == null){
            return false;
        }
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;
        while (fast != null && fast.next != null) {
             

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }


    // we adjust  the tow lists so that they have the same length and then we iterate through them until we find the common node
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        // Step 1: Get the lengths of both lists
        int len1 = 0;
        int len2 = 0;
        
        SinglyLinkedListNode temp1 = head1;
        SinglyLinkedListNode temp2 = head2;
        
        // Calculate length of list 1
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        
        // Calculate length of list 2
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }
        
        // Step 2: Move the pointer of the longer list by the difference in lengths
        temp1 = head1;
        temp2 = head2;
        
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                temp1 = temp1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                temp2 = temp2.next;
            }
        }
        
        // Step 3: Move both pointers until we find the merge point
        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                return temp1.data; // Found the merge node
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return -1; // If no merge node exists, which is not expected as per the problem
    }
    
    public static void main(String[] args) {
        // Create linked list
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertNode(16);
        list.insertNode(13);
        list.insertNode(7);

        System.out.println("Original Linked List:");
        printSinglyLinkedList(list.head);

        // Insert new node
        int data = 1;
        int position = 2;
        list.head = Result.insertNodeAtPosition(list.head, data, position);

        System.out.println("Linked List after insertion:");
        printSinglyLinkedList(list.head);

        System.out.println("Reversed Linked List:");
        Result.reversePrint(list.head);
    }
}

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


  static  class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        // If the head is null, return null (edge case: empty list)
        if (head == null) {
            return null;
        }
    
        // Create a HashMap to store the mapping between original nodes and their clones
        HashMap<Node, Node> hm = new HashMap<>();
        
        // Initialize the current pointer to traverse the original list
        Node current = head;
        
        // Create a clone of the head node and store it in the hashmap
        hm.put(current, new Node(current.val));
    
        // Traverse the original list to clone the nodes and their relationships
        while (current != null) {
            // Get the cloned node from the hashmap
            ////===> here it begins our clone LinkedList
            Node currentClone = hm.get(current);
    
            // If the random pointer is not null and hasn't been cloned yet, create and store it
            if (current.random != null && !hm.containsKey(current.random)) {
                hm.put(current.random, new Node(current.random.val));
            }
            
            // Retrieve the cloned random node (if it exists)
            Node randomClone = hm.get(current.random);
            
            // Assign the cloned random node to the current cloned node
            currentClone.random = randomClone;
    
            // If the next pointer is not null and hasn't been cloned yet, create and store it
            if (current.next != null && !hm.containsKey(current.next)) {
                hm.put(current.next, new Node(current.next.val));
            }
            
            // Retrieve the cloned next node (if it exists)
            Node nextClone = hm.get(current.next);
            
            // Assign the cloned next node to the current cloned node
            currentClone.next = nextClone;
    
            // Move to the next node in the original list
            current = current.next;
        }
        
        // Return the cloned head node from the hashmap
        return hm.get(head);
    }
    
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify the result list
        ListNode current = dummy; // Pointer to track the current node
        int carry = 0; // Variable to store carry

         while(l1 != null || l2 != null){

             int sum = carry; // Start with the carry value

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10; // Carry for the next iteration
            current.next = new ListNode(sum % 10); // Create new node with the last digit of sum
            current = current.next; // Move to the next node
         } 
         
         // If there's a carry left, add an extra node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next; // Return the real head of the resulting list
    }


    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        while(true){
            // here we are just jumping between indexes(main values as index to the next asignement )
            //We are treating the values in nums as indexes and "jumping" between them, just like navigating a linked list.
            slow = nums[slow]; // Move slow by one step
            fast = nums[nums[fast]];// Move fast by two steps
            if(slow == fast){//cycle detected
                break;
            }

        }
        
        //then we should set the slow to the first value sow now we can applay the Floyd's algo to find the intersection point 
        slow = nums[0];
        while (slow != fast) { // Move both pointers at the same pace
            slow = nums[slow]; 
            fast = nums[fast];
        }


        return slow;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1 ) return head;

        ListNode dummy = new  ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode current = head;

        int count = 0;
        while(current != null ){
            count++;
            current = current.next;
        }

        current = head;
        while(count >= k){
            ListNode groupStart = current;
            ListNode prev = null;
            ListNode next = null;
            // Reverse k nodes
            for(int i = 0 ; i < k ; i++){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;

            }
            // Connect previous group's end to new group's start
            prevGroupEnd.next = prev;
            groupStart.next = current;
            prevGroupEnd = groupStart;
             count -= k;
        }
         return dummy.next;

    }
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Count the number of nodes
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // If fewer than k nodes, return head as it is
        if (count < k) return head;

        // Reverse first k nodes
        ListNode prev = null, curr = head, next = null;
        int num = 0;
        while (num < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            num++;
        }

        // Connect reversed part to the remaining nodes
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // New head of reversed part
        return prev;
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

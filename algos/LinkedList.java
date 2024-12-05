package algos;
import java.util.HashSet;
public class LinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    private Node head;
    private static int length;

    public void add(int data) {
        Node newNode = new Node(data); // Create a new node
        if (head == null) { // If the list is empty, make this the head
            head = newNode;
            length++;
        } else {
            Node current = head;
            // Traverse to the end of the list
            while (current.next != null) {
                current = current.next;
            }
            // Add the new node at the end
            length++;
            current.next = newNode;
        }
    }

    public void add(int data, int position) {
        Node node = new Node(data);

        if (position == 1) { // Add at the head
            node.next = head;
            head = node;
            length++;

        } else {
            Node current = head; // Start from the head
            int count = 1;

            // Traverse to the node just before the desired position
            while (count < position - 1 && current != null) {
                current = current.next;
                count++;
            }

            if (current == null) {
                System.out.println("Position out of bounds.");
                return;
            }

            // Insert the new node at the desired position
            node.next = current.next;
            current.next = node;
            length++;

        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public Node deleteFirst() {
        if (head == null)
            return null;
        Node temp = head;
        head = head.next;

        temp.next = null;
        length--;

        return temp;
    }

    public Node deleteLast() {
        if (head == null)
            return null;
        Node current = head;
        Node prev = null;
        while (current.next != null) {
            prev = current;
            current = current.next;

        }
        length--;

        prev.next = null;
        return prev;
    }

    public void remove(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == value) {
            deleteFirst();
            return;
        }
        Node current = head;
        Node prev = null;

        while (current != null && current.data != value) {
            prev = current;
            current = current.next;
        }
        // If the node was not found
        if (current == null) {
            System.out.println("Value not found in the list.");
            return;
        }
        length--;
        // pop up the current we need to remove by asigning the prev next to the current
        // next sow the current now is out!!
        prev.next = current.next;

    }

    public boolean isIn(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Node reverse() {
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev; // means making it null sow it become out of the list
            prev = current;
            current = next;
        }
        return prev;
    }

    public Node nth(int n) {
        if (head == null || n < 0) {
            throw new IllegalArgumentException("Invalid input or empty list");
        }
        Node mainPtr = head;
        Node refPtr = head;
        // Move refPtr n steps ahead
        for (int i = 0; i < n; i++) {
            if (refPtr == null) {
                throw new IllegalArgumentException("n is larger than the length of the list");
            }
            refPtr = refPtr.next;
        }
        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }
    public void removeDup(){
        if(head == null){
            return;
        }
        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;
        
        while(current != null){
            if(seen.contains(current.data)){
                prev.next = current.next;//make the  prev next which is the current in this case skiped and place it with the next val
            }else{
                seen.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

    public Node addInSorted(Node val){
        Node current =  head;
        Node temp = null;

        while(current != null && current.data < val.data){
            temp = current;
            current= current.next;
        }
        val.next = current;
        temp.next = val;
        length++;
        return head;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(1); // Add 10 at position 1
        list.add(2); // Add 20 at position 2
        list.add(3); // Add 15 at position 2 (shifts 20 to position 3)
        list.add(6); // Add 5 at position 1 (shifts all elements)

        // Reverse the list and update the head
        // list.head = list.reverse();
        // System.out.println(length);
        // Display the reversed list
        // System.out.println(list.nth(2));
        //list.display();
        //list.removeDup();
        //list.addInSorted(new Node(7));
        //System.out.println(length);
        list.display();

    }

}

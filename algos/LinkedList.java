package algos;

public class LinkedList {
    static class Node{
        int data;
        Node next;
    

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
    private Node head;
    private int length;



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
        }
    }
    
   
    public void display(){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public Node deleteFirst(){
        if(head == null) return null;
        Node temp =  head;
        head = head.next;
         temp.next = null;
         return temp;
    }

    public Node deleteLast(){
        if(head == null) return null;
        Node current = head;
        Node prev = null;
        while(current.next != null){
            prev = current;
            current = current.next;

        }
        prev.next = null;
        return prev;
    }
    public void remove(int value){
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
    
        while(current != null && current.data != value){
            prev = current;
            current = current.next;
        }
        // If the node was not found
        if (current == null) {
            System.out.println("Value not found in the list.");
            return;
        }

        //pop up the current we need to remove by asigning the prev next to the current next sow the current now is out!!
        prev.next = current.next;

    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
  
        list.add(10, 1); // Add 10 at position 1
        list.add(20, 2); // Add 20 at position 2
        list.add(15, 2); // Add 15 at position 2 (shifts 20 to position 3)
        list.add(5, 1);  // Add 5 at position 1 (shifts all elements)


        list.display();

       
    }

}


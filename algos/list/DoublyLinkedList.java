package algos.list;

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
}

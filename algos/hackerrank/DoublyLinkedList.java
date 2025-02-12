package algos.hackerrank;

public class DoublyLinkedList {
    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;
    
        public DoublyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if (llist == null) {
            return newNode;
        }
        //if data is the new head 
        if(data < llist.data){
            newNode.next = llist;
            llist.prev = newNode;
            return newNode;

    }

    DoublyLinkedListNode current = llist;

    while(current.next != null && current.next.data < data){
        current = current.next;
    }

    newNode.next = current.next;
    newNode.prev = current;
    current.next = newNode;

    if (newNode.next != null) {
        newNode.next.prev = newNode;
    }
    return llist; // Head remains unchanged
}
}
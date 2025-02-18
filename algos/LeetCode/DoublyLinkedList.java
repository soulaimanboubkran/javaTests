package algos.LeetCode;

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

    // just swap the next and prev pointers of each node // so when you swap in each node the next current one will be riched by the prev pointer
    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        if (llist == null) return null; // Handle empty list case
        
        DoublyLinkedListNode current = llist;
        DoublyLinkedListNode newHead = null;

        while (current != null) {
            // Swap next and prev pointers
            DoublyLinkedListNode temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // Move newHead forward
            newHead = current;

            // Move to the next node (which is actually prev now)
            current = current.prev;
        }

        return newHead; // New head is the last node of original list

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
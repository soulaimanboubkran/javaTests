package algos.queue;
import java.util.NoSuchElementException;
public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int length;

    private class  Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data =data;
            this.next =null;
        }
}
    public Queue(){
        front = null;
        rear = null;
        length = 0;
    }
    public int length() {
        return length;
     }
     public boolean isEmpty() {
        return length == 0;
     }
    
    public void enqueue(T data){
        Node<T> temp = new Node<>(data);
        if(isEmpty()){
            front = temp;
        }else{
            rear.next = temp;
        }
        rear =temp;
        length++;
    }
    public void print(){
        if (isEmpty()) {
            return;
         }
        Node<T> current = front;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        } 
        System.out.println("null");
    }

    public T dequeue(){
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is already empty");
         }
        T result =  front.data;
        
        front = front.next;
        if(front == null){
            rear = null;
        }
        length--;
        return result;
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
  
        queue.print();
  System.out.println(queue.dequeue());
  queue.print();
   
  
     
     }

}

package algos.heap;

public class MaxPq {
    private Integer[] heap;
    private int n;

    public MaxPq(int capacity){
        heap = new Integer[capacity + 1];
        n = 0;
    }
    public boolean isEmpty(){
     return n == 0;    
    }

    public int size(){
        return n;
    }

    public void insert(int x){
        if(n == heap.length -1){
            resize(2*heap.length);
        }
        n++;
        heap[n] = x;
        swim(n);
    }



    private void swim(int k){
        while(k > 1 && heap[k/2] < heap[k]){
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;// bcoz we need to continue shifting up till
            // new value inserted is at correct position
        }
    }
    public void printMaxHeap() {
        for (int i = 1; i <= n; i++) {
           System.out.print(heap[i] + " ");
        }
     }
    private void resize(int capacity){
        Integer[] temp = new Integer[capacity];
        for(int i = 0; i < heap.length; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public int deleteMax(){
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap[1];
        swap(1,n);
        n--;
        sink(1);
        return max;
    }
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k; // Left child
            if (j < n && heap[j] < heap[j + 1]) { // Compare left and right children
                j++;
            }
            if (heap[k] >= heap[j]) {
                break; // Heap order is satisfied
            }
            swap(k, j);
            k = j; // Continue sinking
        }
    }

    public static void main(String[] args) {
        MaxPq pq = new MaxPq(3);
        pq.insert(4);
        pq.insert(5);
        pq.insert(2);
        pq.insert(6);
        pq.insert(1);
        pq.insert(3);
        System.out.println("Heap size: " + pq.size());
        pq.printMaxHeap();

        System.out.println("Deleted max: " + pq.deleteMax());
        pq.printMaxHeap();

        System.out.println("Deleted max: " + pq.deleteMax());
        pq.printMaxHeap();
    }
}

package algos.sort;

public class InsertionSort {
    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
           System.out.print(arr[i] + " ");
        }
        System.out.println();
     }

     public void sort(int[] arr){
        int n = arr.length;

        for(int i = 1 ; i < n ;i++){
            int temp = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > temp){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1]  = temp;
        }
     }

     public static void main(String[] args) {
        int[] arr = new int[] { 5, 1, 2, 9,5, 5, 1, 2, 9, 101, 2, 95, 1, 2, 9, 10, 10, 10 };
    
        InsertionSort is = new InsertionSort();
    
        System.out.println("Original array:");
        is.printArray(arr);
    
        // Record start time
        long startTime = System.nanoTime();
    
        // Sort the array
        is.sort(arr);
    
        // Record end time
        long endTime = System.nanoTime();
    
        System.out.println("Sorted array:");
        is.printArray(arr);
    
        // Calculate and print duration
        long duration = endTime - startTime;
        System.out.println("Time taken to sort (in nanoseconds): " + duration);
        System.out.println("Time taken to sort (in milliseconds): " + (duration / 1_000_000));
    }
    
}

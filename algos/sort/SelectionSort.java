package algos.sort;

public class SelectionSort {
    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 1, 2, 9, 10 };
        SelectionSort ss = new SelectionSort();

        System.out.println("Original array:");
        ss.printArray(arr);

        // Record start time
        long startTime = System.nanoTime();

        // Sort the array
        ss.sort(arr);

        // Record end time
        long endTime = System.nanoTime();

        System.out.println("Sorted array:");
        ss.printArray(arr);

        // Calculate and print duration
        long duration = endTime - startTime;
        System.out.println("Time taken to sort (in nanoseconds): " + duration);
        System.out.println("Time taken to sort (in milliseconds): " + (duration / 1_000_000));
    }
}

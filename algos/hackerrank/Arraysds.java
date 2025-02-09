package algos.hackerrank;

import java.util.*;

public class Arraysds {

    public static List<Integer> reverseArray(List<Integer> a) {

        // sow this one iterates only half the array and swaps the elements from the
        // front and back of the array
        for (int i = 0; i < a.size() / 2; i++) {
            int temp = a.get(i);
            a.set(i, a.get(a.size() - 1 - i));
            a.set(a.size() - 1 - i, temp);
        }
        return a;
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        if (arr.size() < 6 || arr.get(0).size() < 6) {
            throw new IllegalArgumentException("The matrix must be 6x6.");
        }
        // Write your code here
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.size() - 3; i++) { // Fixed iteration limit
            for (int j = 0; j <= arr.get(i).size() - 3; j++) { // Fixed iteration limit
                int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
                        + arr.get(i + 1).get(j + 1)
                        + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);

                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // O(n*d)
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        List<Integer> mutableList = new ArrayList<>(arr); // Convert to mutable list

        // normaly when we peak the first element the array shifts to the left
        for (int i = 0; i < d; i++) {
            int temp = mutableList.remove(0); // Remove first element
            mutableList.add(temp); // Add it to the end
        }

        return mutableList;
    }

    // O(n)
    public static List<Integer> rotateLeft2(int d, List<Integer> arr) {
        int n = arr.size();
        List<Integer> rotated = new ArrayList<>(n);

        // Iterate through the array and shift indices
        for (int i = 0; i < n; i++) {
            rotated.add(arr.get((i + d) % n));
        }

        return rotated;
    }

    public static List<Integer> rotateLeft3(int d, List<Integer> arr) {
        int n = arr.size();
        List<Integer> rotated = new ArrayList<>(n);

        // Start from index 'd' and go to the end
        for (int i = d; i < n; i++) {
            rotated.add(arr.get(i));
        }

        // Add the first 'd' elements to the end
        for (int i = 0; i < d; i++) {
            rotated.add(arr.get(i));
        }

        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> testArray = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> reversedArray = reverseArray(new ArrayList<>(testArray));

        System.out.println("Original: " + testArray);
        System.out.println("Reversed: " + reversedArray);

        // Hourglass Sum Test
        List<List<Integer>> testMatrix = Arrays.asList(
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 1, 0, 0, 0, 0),
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 0, 2, 4, 4, 0),
                Arrays.asList(0, 0, 0, 2, 0, 0),
                Arrays.asList(0, 0, 1, 2, 4, 0));

        int out = hourglassSum(testMatrix);
        System.out.println("Max Hourglass Sum: " + out);

        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int d = 2;
        System.out.println(rotateLeft(d, arr));

    }
}

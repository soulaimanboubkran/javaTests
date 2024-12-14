package algos.stack;

import algos.stack.List.Stack;

public class NextGreater {

    public int[] findNextGreaterElements(int[] arr) {
        // Handle edge case for empty array
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int[] result = new int[arr.length];
        Stack stack = new Stack(); // Assuming Stack implementation is available

        // Traverse the array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // Remove elements from stack that are less than or equal to current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack is empty, no greater element exists
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek(); // Top of stack is the next greater element
            }

            // Push the current element onto the stack
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreater ng = new NextGreater();

        int[] arr = {4, 5, 2, 10, 8};
        int[] result = ng.findNextGreaterElements(arr);

        // Expected Output: [5, 10, 10, -1, -1]
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}

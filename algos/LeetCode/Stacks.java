package algos.LeetCode;

import java.util.*;

public class Stacks {
    
    public static boolean isValid(String s) {
        Stack<Character>  stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty() ) return false;

                char top = stack.pop();
                if((c == ')' && top != '(') || 
                (c == '}' && top != '{') || 
                (c == ']' && top != '[')) {
                return false;
            }
        }
    }
    return stack.isEmpty();
}
public  List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    Stack<Character> stack = new Stack<>();

    backtrack(res,stack,0,0,n);
       return res; 
}

private void backtrack(List<String> res,Stack<Character> stack ,int openCount,int closeCount,int n ){

    if(openCount == n && closeCount == n){
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }
        res.add(sb.toString());
        return;
    }


    if(openCount < n){
        stack.push('(');
        backtrack(res, stack, openCount + 1, closeCount, n);
        stack.pop();// Backtrack

    }
    if(closeCount < closeCount){
        stack.push(')');
        backtrack(res, stack, openCount, closeCount + 1, n);
        stack.pop();// Backtrack

    }
}



 public int[] dailyTemperatures(int[] temperatures) {
       Stack<Integer> stack = new Stack<>();
       int[] map = new int[temperatures.length];
       
       for(int i= 0 ; i < temperatures.length ; i++){
        while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
            Integer topIndex = stack.pop();
            int diff = i - topIndex;
            map[topIndex] = diff;
        }
        stack.push(i);
       }
       while(!stack.isEmpty()){
        Integer topIndex = stack.pop();
        map[topIndex] = 0;
       }
       return map;
 }
public static int evalRPN(String[] tokens) {
         Stack<Integer> stack = new Stack<>();
  

         for(String s : tokens){
           if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")){
                stack.push(Integer.parseInt(s));
           }else{
            int nbr2 = stack.pop();
            int nbr1 = stack.pop();
            int res = 0;

            switch (s) {
                case "+":
                    res = nbr1 + nbr2;
                    break;
                case "-":
                    res = nbr1 - nbr2;
                    break;
                case "*":
                    res = nbr1 * nbr2;
                    break;
                case "/":
            
                    res = nbr1 / nbr2;
                    
                    break;
            
                
                    
            }
            stack.push(res);
           }
         }
         return stack.pop();
}

public int carFleet(int target, int[] position, int[] speed) {
       int n = position.length;
       if(n == 1 ) return 1;

        // Step 1: Create a list of cars (position, timeToTarget)
       double[][] cars = new double[n][2];
       for(int i = 0 ; i < n ; i++){
        cars[i][0] = position[i];
        cars[i][1] = (double) (target - position[i]) / speed[i];  // Fix integer division

       }
       // Sort by position descending
       Arrays.sort(cars,(a,b)->Double.compare(b[0], a[0]));

       Stack<Double> stack = new Stack<>();
       for(double[] car : cars){
           double time = car[1];

           // the fleet happed when there is individual car or the prev car will rich to the target faster
           if(stack.isEmpty() || time > stack.peek()){
            stack.push(time);
           }
       }

       return stack.size();

}


public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>(); // Stack to store indices of histogram bars
    int maxArea = 0; // Variable to track the maximum rectangle area
    int n = heights.length; // Length of the histogram array
    
    // Iterate through each bar, including an extra iteration (i == n) to process remaining bars
    for (int i = 0; i <= n; i++) {
        int h = (i == n) ? 0 : heights[i]; // If at the end, treat height as 0 to clear stack
        
        // Process the stack when the current height is smaller than the height at stack's top
        while (!stack.isEmpty() && h < heights[stack.peek()]) {
            int height = heights[stack.pop()]; // Get the height of the popped bar
            
            // Determine the width of the largest rectangle using this height
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            
            // Update the maximum area found so far
            maxArea = Math.max(maxArea, height * width);
        }
        
        // Push the current index onto the stack
        stack.push(i);
    }
    
    return maxArea; // Return the largest found rectangle area
}
//---------------------------------------------------------------------

public class MinStack{
    private Node head;
    public MinStack(){

    }


    private class Node{
        int val;
        int min;
        Node next;
        public Node(int val,int min ,Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }


    }

    public void push(int val){
        if(head == null){
            head = new Node(val, val, null);
        }else{
            head = new Node(val, Math.min(val,head.min), head);
        }
    }
    public void pop(){
        head = head.next;
    }

    public int top(){
        return head.val;
    }
    public int getMin(){
        return head.min;
    }


}





}

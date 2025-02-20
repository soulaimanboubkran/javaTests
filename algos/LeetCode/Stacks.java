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
        //this one is responsable of the pop up the last element in the stack sow when we rich openCount < closeCount sow it can now add something and start again new option 
        stack.pop();// Backtrack

    }
    if(closeCount < closeCount){
        stack.push(')');
        backtrack(res, stack, openCount, closeCount + 1, n);
        stack.pop();// Backtrack

    }
}
/*
 * "This part is responsible for popping the last element from the stack. When openCount < closeCount, it means we can now add a new element and start exploring a different option."

Breaking it Down for Clarity
"this one is responsable" → "This part is responsible"
"responsable" is incorrect spelling; it should be "responsible."
"of the pop up the last element" → "for popping the last element"
"pop up" is incorrect; in programming, we say "popping" when removing from a stack.
"in the stack sow when we rich" → "from the stack. When we reach"
"sow" should be "so" (but "so" isn't needed here).
"rich" should be "reach."
"openCount < closeCount sow it can now add something" → "When openCount < closeCount, it means we can now add a new element"
"sow" should be "so."
"add something" is too vague; I replaced it with "add a new element."
"and start again new option" → "and start exploring a different option."
"start again new option" is incorrect phrasing.
"start exploring a different option" is a clearer way to express the idea.
 * 
 */


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

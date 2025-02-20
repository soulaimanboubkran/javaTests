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
public static List<String> generateParenthesis(int n) {

    
       return null; 
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

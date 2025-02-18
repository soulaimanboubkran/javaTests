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

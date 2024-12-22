package algos.tree;

import java.util.Stack;

import java.util.LinkedList;

import java.util.Queue;

public class BinaryTree<T> {
    private TreeNode root;

    // Nested TreeNode class, inherits generic type T from BinaryTree
    private class TreeNode {
        private T data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    // Pre-order traversal using an iterative approach
    public void preOrder() {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }
    // in order is from the lef left to root to lef right
    public void inOrder() {
        if (root == null) {
           return;
        }
      
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
  
        while (!stack.isEmpty() || temp != null) {
           if (temp != null) {
              stack.push(temp);
              temp = temp.left;
           } else {
              temp = stack.pop();
              System.out.print(temp.data + " ");
              temp = temp.right;
           }
        }
     }
     public void postOrder(){
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else {
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                }else{
                    current = temp;
                }
            }
        }
     }


     public void levelOrder(){
        if (root == null) {
            return;
         }
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         while(!queue.isEmpty()){
            TreeNode temp= queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null){
                queue.offer(temp.left); 
            }
            if(temp.right != null){
                queue.offer(temp.right); 
            }

                 }
         
     }
    // Adds a root node to the tree
    public void addRoot(T data) {
        root = new TreeNode(data);
    }

    // Adds children to a specific parent node
    public void setChildren(TreeNode parent, T leftData, T rightData) {
        parent.left = new TreeNode(leftData);
        parent.right = new TreeNode(rightData);
    }

    // Sample binary tree creation for demonstration
    @SuppressWarnings("unchecked")
    public void createSampleBinaryTree() {
        // Root node
        root = new TreeNode((T) Integer.valueOf(1));

        // Adding children to root
        root.left = new TreeNode((T) Integer.valueOf(2));
        root.right = new TreeNode((T) Integer.valueOf(3));

        // Adding grandchildren
        root.left.left = new TreeNode((T) Integer.valueOf(4));
        root.left.right = new TreeNode((T) Integer.valueOf(5));
        root.right.left = new TreeNode((T) Integer.valueOf(6));
        root.right.right = new TreeNode((T) Integer.valueOf(7));
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.createSampleBinaryTree();
        System.out.println("Pre-order traversal:");
        bt.preOrder();
        System.out.println("");
        System.out.println("In-order traversal:");
        bt.inOrder();
        System.out.println("");
        System.out.println("Post-order traversal:");
        bt.postOrder();
        System.out.println("");
        System.out.println("level-Order :");
        bt.levelOrder();
    }
}

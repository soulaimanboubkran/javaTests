package algos.tree;

import java.util.Stack;

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
    }
}

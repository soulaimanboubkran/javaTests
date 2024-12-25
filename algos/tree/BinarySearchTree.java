package algos.tree;

public class BinarySearchTree<T extends Number & Comparable<T>> {
    private TreeNode root;

    // Nested TreeNode class
    private class TreeNode {
        private T data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode root, T value) {
        if (root == null) {
            return new TreeNode(value);
        }

        // Use compareTo to compare values
        if (value.compareTo(root.data) < 0) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public TreeNode search(T key) {
        return search(root, key);
    }

    private TreeNode search(TreeNode root, T key) {
        if (root == null || root.data.equals(key)) {
            return root;
        }
        if (key.compareTo(root.data) < 0) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(4);
        bst.insert(3);
        bst.insert(6);
        bst.insert(2);

        bst.inOrder(); // Outputs: 2 3 4 6

        if (bst.search(2) != null) {
            System.out.println("\nKey was found!");
        } else {
            System.out.println("\nKey was not found!");
        }
    }
}

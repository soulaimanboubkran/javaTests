package algos.tree;

public class BinaryTree<T> {
    private TreeNode root;


    private class  TreeNode{
        private T data;
        private TreeNode left;
        private TreeNode right;


        public TreeNode(T data){
            this.data = data;
        }
    
    }
}

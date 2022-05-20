import javax.swing.tree.TreeNode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        //https://leetcode.com/problems/count-complete-tree-nodes/ 222
        if(root == null) return 0;
        int l = left(root);
        int r  = right(root);
        if(l == r){
            return (int) Math.pow(2,l)-1;
        }

        return countNodes(root.left) + countNodes(root.right) +1;
    }

    private int left(TreeNode root){
        if(root == null) return 0;
        return left(root.left)+1;
    }

    private int right(TreeNode root){
        if(root == null) return 0;
        return right(root.right)+1;
    }
}

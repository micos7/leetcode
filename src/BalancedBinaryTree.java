public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        //https://leetcode.com/problems/balanced-binary-tree/ 110
        if (root == null) return true;

        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}

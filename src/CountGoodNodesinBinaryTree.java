import javax.swing.tree.TreeNode;

public class CountGoodNodesinBinaryTree {
    public int goodNodes(TreeNode root) {
        //https://leetcode.com/problems/count-good-nodes-in-binary-tree/ 1448
        return helper(root, root.val);
    }

    private int helper(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int max = Math.max(root.val, val);
        return (root.val >= val ? 1 : 0) + helper(root.left, max) + helper(root.right, max);
    }
}

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        //https://leetcode.com/problems/maximum-depth-of-binary-tree/ 104
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}

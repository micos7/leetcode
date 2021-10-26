public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //https://leetcode.com/problems/path-sum/ 112
        if (root == null) return false;

        if (root.right == null && root.left == null && root.val == targetSum) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

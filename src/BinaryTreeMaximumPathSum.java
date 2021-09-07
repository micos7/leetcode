public class BinaryTreeMaximumPathSum {
    //https://leetcode.com/problems/binary-tree-maximum-path-sum/ 124
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxSum;
    }

    private int maxSum(TreeNode root) {


        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxSum(root.left));
        int right = Math.max(0, maxSum(root.right));
        int curSum = root.val + left + right;

        maxSum = Math.max(maxSum, curSum);

        return Math.max(left, right) + root.val;
    }
}

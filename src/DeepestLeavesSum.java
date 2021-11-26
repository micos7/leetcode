public class DeepestLeavesSum {
    int sum = 0;
    int deepest = 0;

    public int deepestLeavesSum(TreeNode root) {
        https://leetcode.com/problems/deepest-leaves-sum/ 1302
        helper(root, 0);

        return sum;

    }

    private void helper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (depth == deepest) {
                sum += root.val;
            } else if (deepest < depth) {
                sum = 0;
                sum += root.val;
                deepest = depth;
            }

        }
        helper(root.right, depth + 1);
        helper(root.left, depth + 1);

    }
}

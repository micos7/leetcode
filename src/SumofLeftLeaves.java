public class SumofLeftLeaves {
    //https://leetcode.com/problems/sum-of-left-leaves/ 404
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        sum(root, false);

        return sum;
    }

    private void sum(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (isLeft && root.left == null && root.right == null) {
            sum += root.val;
            return;
        }

        sum(root.left, true);
        sum(root.right, false);
        return;
    }
}

import javax.swing.tree.TreeNode;

public class PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        //https://leetcode.com/problems/path-sum-iii/ 437
        if (root == null) return 0;


        int i = dfs(root, targetSum),
                left = pathSum(root.left, targetSum),
                right = pathSum(root.right, targetSum);

        return i + left + right;

    }

    private int dfs(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int ways = 0;
        if (targetSum == root.val) ways++;

        ways += dfs(root.left, targetSum - root.val);
        ways += dfs(root.right, targetSum - root.val);

        return ways;
    }
}

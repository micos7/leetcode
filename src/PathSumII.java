import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //https://leetcode.com/problems/path-sum-ii/ 113
        List<List<Integer>> ans = new ArrayList<>();
        traverse(root, targetSum, ans, new ArrayList<Integer>());
        return ans;
    }

    private void traverse(TreeNode root, int targetSum, List<List<Integer>> ans, ArrayList<Integer> temp) {
        if (root == null) {
            return;
        }
        temp.add(root.val);

        if (root.val == targetSum && root.left == null && root.right == null) {
            ans.add(temp);
            return;
        }
        traverse(root.left, targetSum - root.val, ans, new ArrayList<Integer>(temp));
        traverse(root.right, targetSum - root.val, ans, new ArrayList<Integer>(temp));

    }
}

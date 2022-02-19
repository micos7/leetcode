import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        //https://leetcode.com/problems/binary-tree-preorder-traversal/ 144
        List<Integer> ans = new ArrayList<>();
        return rec(root, ans);
    }

    private List<Integer> rec(TreeNode root, List<Integer> ans) {
        if (root == null) return ans;
        ans.add(root.val);
        ans = rec(root.left, ans);

        return rec(root.right, ans);
    }
}

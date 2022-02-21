import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        //https://leetcode.com/problems/binary-tree-postorder-traversal/ 145
        return rec(root, new ArrayList<>());
    }

    private List<Integer> rec(TreeNode root, List<Integer> ans) {
        if (root == null) return ans;
        ans = rec(root.left, ans);
        ans = rec(root.right, ans);
        ans.add(root.val);
        return ans;
    }
}

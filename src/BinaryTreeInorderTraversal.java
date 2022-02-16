import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        //https://leetcode.com/problems/binary-tree-inorder-traversal/ 94
        if (root == null) {
            return ans;
        }
        ans = inorderTraversal(root.left);
        ans.add(root.val);
        return inorderTraversal(root.right);
    }
}

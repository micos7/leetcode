import javax.swing.tree.TreeNode;

public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/ 236
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}

import javax.swing.tree.TreeNode;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode d = root;
        while (d.right != null) {
            d = d.right;
        }
        d.right = right;
    }
}

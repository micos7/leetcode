public class UnivaluedBinaryTree {
    public int val;
    boolean isUni = true;

    public boolean isUnivalTree(TreeNode root) {
        //https://leetcode.com/problems/univalued-binary-tree/ 965
        val = root.val;
        check(root);
        return isUni;
    }

    private void check(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val != val) {
            isUni = false;
            return;
        }

        check(root.right);
        check(root.left);

    }
}

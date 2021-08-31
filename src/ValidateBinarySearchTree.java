public class ValidateBinarySearchTree {
    //https://leetcode.com/problems/validate-binary-search-tree/ 98
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    public boolean valid(TreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        } else if (max != null && max <= root.val || min != null && min >= root.val) {
            return false;
        } else {
            return valid(root.left, root.val, min) && valid(root.right, max, root.val);
        }
    }
}

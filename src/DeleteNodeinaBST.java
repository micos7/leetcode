public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        //https://leetcode.com/problems/delete-node-in-a-bst/ 450
        if (root == null) {
            return root;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode nextRight = root.right;
                while (nextRight.left != null) {
                    nextRight = nextRight.left;
                }
                nextRight.left = root.left;
                return root.right;
            }
        }
    }
}

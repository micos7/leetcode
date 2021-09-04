public class ConstructBinaryTreefromPreorderandInorderTraversal {
    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/ 105
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return rec(0, 0, inorder.length - 1, preorder, inorder);
    }


    public TreeNode rec(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorder[i]) {
                inIndex = i;
            }
        }

        root.left = rec(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = rec(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

        return root;
    }
}

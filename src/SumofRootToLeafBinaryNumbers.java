public class SumofRootToLeafBinaryNumbers {
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        //https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/ 1022
        if (root == null) {
            return 0;
        }
        traverse(root, 0);
        return sum;

    }

    private void traverse(TreeNode root, int val) {
        if (root == null) {
            return;
        }

        val += root.val;
        if (root.left == null && root.right == null) {
            sum += val;
            return;
        }
        traverse(root.left, val * 2);
        traverse(root.right, val * 2);
    }
}

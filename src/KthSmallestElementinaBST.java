public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        //https://leetcode.com/problems/kth-smallest-element-in-a-bst/ 230
        int[] nums = new int[2];

        rec(root, nums, k);

        return nums[1];
    }

    private void rec(TreeNode root, int[] nums, int k) {
        if (root == null) {
            return;
        }

        rec(root.left, nums, k);

        if (++nums[0] == k) {
            nums[1] = root.val;
            return;
        }

        rec(root.right, nums, k);
    }
}

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/ 108
        return rec(nums, 0, nums.length - 1);
    }

    private TreeNode rec(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = rec(nums, l, mid - 1);
        t.right = rec(nums, mid + 1, r);
        return t;
    }
}

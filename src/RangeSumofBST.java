public class RangeSumofBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        //https://leetcode.com/problems/range-sum-of-bst/ 938
        helper(root,low,high);
        return sum;
    }

    private void helper(TreeNode root, int low, int high){
        if(root == null){
            return;
        }

        if(root.val <= high && root.val >= low){
            sum+= root.val;
        }
        if(root.val >= low){
            helper(root.left,low,high);
        }
        if(root.val <= high){
            helper(root.right,low,high);
        }

    }
}

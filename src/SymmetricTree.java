public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        //https://leetcode.com/problems/symmetric-tree/ 101
        return traverse(root.left,root.right);
    }

    public boolean traverse(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }else if ( left == null || right == null  || left.val != right.val){
            return false;
        }else{
            return traverse(left.left,right.right) && traverse(right.left,left.right);
        }
    }
}

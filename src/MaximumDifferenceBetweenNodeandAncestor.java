public class MaximumDifferenceBetweenNodeandAncestor {
    int maxdif=0;
    public int maxAncestorDiff(TreeNode root) {
        //https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/ 1026
        traverse(root);
        return maxdif;
    }

    private int[] traverse(TreeNode root){
        if(root == null){
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int leftmin = left[0];
        int rightmin = right[0];

        int min = Math.min(root.val,Math.min(leftmin,rightmin));

        int leftmax = left[1];
        int rightmax = right[1];

        int max = Math.max(root.val,Math.max(leftmax,rightmax));

        maxdif = Math.max((max - root.val), Math.max((root.val - min), maxdif));

        return new int[]{min,max};
    }
}

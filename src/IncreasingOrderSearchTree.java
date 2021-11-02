import java.util.List;

public class IncreasingOrderSearchTree {
    //https://leetcode.com/problems/increasing-order-search-tree/ 897
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root;
        List<Integer> l = new ArrayList();
        inOrder(temp,l);
        TreeNode newHead = new TreeNode(0);
        TreeNode newRoot = newHead;
        for(Integer i: l){
            newHead.right = new TreeNode(i);
            newHead = newHead.right;
        }
        return newRoot.right;
    }

    public void inOrder(TreeNode root, List<Integer> l){
        if(root == null){
            return;
        }
        inOrder(root.left,l);
        l.add(root.val);
        inOrder(root.right,l);

    }
}

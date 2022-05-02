import javax.swing.tree.TreeNode;
import java.util.HashMap;

public class MaximumWidthofBinaryTree {
    int width;
    HashMap<Integer,Integer> h;
    public int widthOfBinaryTree(TreeNode root) {
        //https://leetcode.com/problems/maximum-width-of-binary-tree/ 662
        h = new HashMap<>();
        width = 0;
        traverse(root,0,0);
        return width;
    }

    private void traverse(TreeNode root,int depth, int position){
        if(root == null) return;
        h.computeIfAbsent(depth,x->position);
        width = Math.max(width,position - h.get(depth)+1);
        traverse(root.left,depth+1,position*2);
        traverse(root.right,depth+1,position*2+1);
    }
}

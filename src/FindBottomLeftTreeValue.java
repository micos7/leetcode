import javax.swing.tree.TreeNode;

public class FindBottomLeftTreeValue {
    int height,ans;
    public int findBottomLeftValue(TreeNode root) {
        //https://leetcode.com/problems/find-bottom-left-tree-value/ 513
        height = 0; ans = 0;

        find(root,1);
        return ans;
    }

    public void find(TreeNode root, int depth){
        if(height < depth){
            height = depth;
            ans = root.val;
        }
        if(root.left != null){
            find(root.left, depth+1);
        }
        if(root.right != null){
            find(root.right, depth+1);
        }
    }
}

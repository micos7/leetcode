import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    List<TreeNode> heads = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] d) {
        //https://leetcode.com/problems/delete-nodes-and-return-forest/
        for (int i : d) {
            set.add(i);
        }
        dfs(root, true);
        return heads;
    }

    private boolean dfs(TreeNode node, boolean head) {
        if (node == null) return false;
        boolean del = set.contains(node.val);
        if (head && !del) {
            heads.add(node);
        }
        if (dfs(node.left, del)) node.left = null;
        if (dfs(node.right, del)) node.right = null;
        return del;
    }
}

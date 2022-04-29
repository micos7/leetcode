import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {
    //https://leetcode.com/problems/minimum-distance-between-bst-nodes/ 783
    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        List<Integer> l = new ArrayList<>();

        traverse(root, l);

        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < l.size() - 1; i++) {
            diff = Math.min(diff, l.get(i + 1) - l.get(i));
        }

        return diff;
    }

    private void traverse(TreeNode root, List<Integer> l) {
        if (root == null) return;

        traverse(root.left, l);
        l.add(root.val);
        traverse(root.right, l);
    }
}

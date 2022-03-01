import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/ 103
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                root = q.poll();
                level.add(root.val);
                if (root.left != null) q.add(root.left);
                if (root.right != null) q.add(root.right);
            }
            if (reverse) Collections.reverse(level);
            reverse = !reverse;
            ans.add(level);
        }

        return ans;
    }
}

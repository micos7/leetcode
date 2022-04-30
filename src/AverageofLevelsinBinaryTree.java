import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        //https://leetcode.com/problems/average-of-levels-in-binary-tree/ 637
        List<Double> l = new ArrayList<>();
        if (root == null) return l;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        double sum = 0;

        while (!q.isEmpty()) {
            sum = 0;
            int size = q.size();
            int orig_size = q.size();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                sum += cur.val;
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            double cur_avg = sum / orig_size;
            l.add(cur_avg);
        }

        return l;
    }
}

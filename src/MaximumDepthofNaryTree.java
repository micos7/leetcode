public class MaximumDepthofNaryTree {
    public int maxDepth(Node root) {
        //https://leetcode.com/problems/maximum-depth-of-n-ary-tree/ 559
        if (root == null) {
            return 0;
        }
        int max = 0;

        for (Node c : root.children) {
            max = Math.max(max, maxDepth(c));
        }

        return max + 1;
    }
}

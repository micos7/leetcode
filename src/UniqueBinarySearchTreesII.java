public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        //https://leetcode.com/problems/unique-binary-search-trees-ii/ 95
        return rec(1, n);

    }

    private List<TreeNode> rec(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = rec(start, i - 1);
            List<TreeNode> right = rec(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }

        }
        return ans;
    }
}

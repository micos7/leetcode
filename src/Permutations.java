import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        //https://leetcode.com/problems/permutations/ 46
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        boolean[] visited = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        rec(nums, permutation, visited, ans);
        return ans;
    }

    private void rec(int[] nums, List<Integer> permutation, boolean[] visited, List<List<Integer>> ans) {
        if (permutation.size() == nums.length) {
            ans.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            permutation.add(nums[i]);
            rec(nums, permutation, visited, ans);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}

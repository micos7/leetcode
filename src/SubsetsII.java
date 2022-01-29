import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //https://leetcode.com/problems/subsets-ii/ 90
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        traverse(0, ans, new ArrayList<Integer>(), nums);
        return ans;
    }

    private void traverse(int index, List<List<Integer>> ans, List<Integer> temp, int[] nums) {
        ans.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            traverse(i + 1, ans, temp, nums);
            temp.remove(temp.size() - 1);

        }

    }
}

import java.util.HashMap;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        //https://leetcode.com/problems/partition-equal-subset-sum/ 416
        int total = 0;
        for (int n : nums) {
            total += n;
        }

        if (total % 2 != 0) {
            return false;
        }

        return helper(nums, 0, 0, total, new HashMap<String, Boolean>());
    }


    private boolean helper(int[] nums, int idx, int sum, int total, HashMap<String, Boolean> state) {
        if (sum * 2 == total) {
            return true;
        }
        if (sum > total / 2 || idx >= nums.length) {
            return false;
        }
        String key = idx + " " + sum;
        if (state.containsKey(key)) {
            return state.get(key);
        }

        boolean ans = helper(nums, idx + 1, sum, total, state) || helper(nums, idx + 1, sum + nums[idx], total, state);
        state.put(key, ans);
        return ans;
    }
}

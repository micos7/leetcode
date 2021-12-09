public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        //https://leetcode.com/problems/target-sum/ 494
        return helper(nums, 0, 0, target);
    }

    private int helper(int[] nums, int pos, int sum, int target) {
        if (nums.length == pos) {
            return sum == target ? 1 : 0;
        }
        return helper(nums, pos + 1, sum - nums[pos], target) +
                helper(nums, pos + 1, sum + nums[pos], target);
    }
}

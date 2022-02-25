public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        //https://leetcode.com/problems/minimum-size-subarray-sum/ 209
        int L = 0;
        int curSum = 0;
        int min = Integer.MAX_VALUE;
        for (int R = 0; R < nums.length; R++) {
            curSum += nums[R];
            while (curSum >= target) {
                min = Math.min(min, R - L + 1);
                curSum -= nums[L];
                L++;
            }

        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

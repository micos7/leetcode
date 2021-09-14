public class MaximumProductSubarray {
    //https://leetcode.com/problems/maximum-product-subarray/ 152
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int cur_max = nums[0];
        int cur_min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int previous_cur_max = cur_max;
            cur_max = Math.max(nums[i], Math.max(cur_max * nums[i], cur_min * nums[i]));
            cur_min = Math.min(nums[i], Math.min(previous_cur_max * nums[i], cur_min * nums[i]));
            result = Math.max(result, cur_max);
        }
        return result;
    }
}

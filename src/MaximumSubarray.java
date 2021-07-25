public class MaximumSubarray {
    // https://leetcode.com/problems/maximum-subarray/ 53
    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int realMax = nums[0];

        for(int i = 1;i<nums.length;i++){
            currentMax= Math.max(nums[i], nums[i] + currentMax);

            if(currentMax > realMax){
                realMax = currentMax;
            }
        }

        return realMax;
    }
}

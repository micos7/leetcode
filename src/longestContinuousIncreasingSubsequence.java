public class longestContinuousIncreasingSubsequence {
    //https://leetcode.com/problems/longest-continuous-increasing-subsequence/ 674
    public int findLengthOfLCIS(int[] nums) {
        int length = 0;
        int wall = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i])
                wall = i;
            length = Math.max(length, i - wall + 1);

        }
        return length;
    }
}

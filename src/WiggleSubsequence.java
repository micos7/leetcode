public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        //https://leetcode.com/problems/wiggle-subsequence/ 376
        if (nums.length == 1) return 1;
        int ans = 1, curDif = 0, prevDif = 0;

        for (int i = 1; i < nums.length; i++) {
            curDif = nums[i] - nums[i - 1];

            if ((curDif > 0 && prevDif <= 0) || (curDif < 0 && prevDif >= 0)) {
                ans++;
                prevDif = curDif;
            }
        }

        return ans;
    }
}

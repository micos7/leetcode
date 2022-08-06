public class MaximumScoreofaGoodSubarray {
    public int maximumScore(int[] nums, int k) {
        //https://leetcode.com/problems/maximum-score-of-a-good-subarray/ 1793
        int n = nums.length, score = nums[k], lo = 0, hi = n - 1;
        int[] runningMinFromIndexK = new int[n];
        runningMinFromIndexK[k] = nums[k];
        for (int i = k + 1; i < n; ++i) {
            runningMinFromIndexK[i] = Math.min(runningMinFromIndexK[i - 1], nums[i]);
        }
        for (int i = k - 1; i >= 0; --i) {
            runningMinFromIndexK[i] = Math.min(runningMinFromIndexK[i + 1], nums[i]);
        }
        while (lo < hi) {
            score = Math.max(score, (hi - lo + 1) * Math.min(runningMinFromIndexK[lo], runningMinFromIndexK[hi]));
            if (runningMinFromIndexK[lo] < runningMinFromIndexK[hi]) {
                ++lo;
            } else {
                --hi;
            }
        }
        return score;
    }
}

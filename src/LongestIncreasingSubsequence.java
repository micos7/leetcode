import java.util.TreeSet;

public class LongestIncreasingSubsequence {
    //https://leetcode.com/problems/longest-increasing-subsequence/ 300
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int num : nums) {
            Integer highest = ts.ceiling(num);
            if (highest == null) {
                ts.add(num);
            } else {
                ts.remove(highest);
                ts.add(num);
            }
        }

        return ts.size();
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}

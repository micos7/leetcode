import java.util.HashMap;
import java.util.Map;

public class OnesandZeroes {
    Map<Integer, Integer> ones;
    Map<Integer, Integer> zeros;

    public int findMaxForm(String[] strs, int m, int n) {
        //https://leetcode.com/problems/ones-and-zeroes/ 474

        ones = new HashMap<>();
        zeros = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            for (char ch : strs[i].toCharArray()) {
                if (ch == '0') {
                    zeros.put(i, zeros.getOrDefault(i, 0) + 1);
                } else {
                    ones.put(i, ones.getOrDefault(i, 0) + 1);
                }
            }
        }

        int[][][] dp = new int[m + 1][n + 1][strs.length];

        return countLargestSubset(strs, dp, m, n, 0);
    }

    public int countLargestSubset(String[] strs, int[][][] dp, int m, int n, int index) {

        if (index == strs.length || m + n == 0)
            return 0;

        if (dp[m][n][index] > 0)
            return dp[m][n][index];

        int one = ones.get(index) == null ? 0 : ones.get(index);
        int zero = zeros.get(index) == null ? 0 : zeros.get(index);

        int take = 0;
        if (m >= zero && n >= one)
            take = 1 + countLargestSubset(strs, dp, m - zero, n - one, index + 1);
        int skip = countLargestSubset(strs, dp, m, n, index + 1);

        dp[m][n][index] = Math.max(take, skip);

        return dp[m][n][index];
    }
}

import java.util.List;

public class MaximumValueofKCoinsFromPiles {
    Integer[][] dp;

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        //https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/ 2218
        int p = piles.size();
        dp = new Integer[p + 1][k + 1];
        return rec(piles, p - 1, k);
    }

    private int rec(List<List<Integer>> piles, int i, int k) {
        if (i < 0 || k == 0) return 0;
        if (dp[i][k] != null) return dp[i][k];

        int n = Math.min(piles.get(i).size(), k);

        int exclude = rec(piles, i - 1, k);

        int include = 0;

        for (int j = 0, sum = 0; j < n; j++) {
            sum += piles.get(i).get(j);
            include = Math.max(sum + rec(piles, i - 1, k - j - 1), include);
        }

        int res = Math.max(include, exclude);

        dp[i][k] = res;

        return res;
    }
}

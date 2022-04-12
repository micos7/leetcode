public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        //https://leetcode.com/problems/last-stone-weight-ii/ 1049
        int total = 0;
        for (int s : stones) total += s;

        boolean[] dp = new boolean[total / 2 + 1];
        dp[0] = true;
        int maxS2 = 0;
        for (int s : stones) {
            boolean[] temp = dp.clone();
            for (int sum = s; sum <= total / 2; sum++) {
                if (dp[sum - s]) {
                    temp[sum] = true;
                    maxS2 = Math.max(maxS2, sum);
                    if (maxS2 == total / 2) return total - maxS2 * 2;
                }
            }

            dp = temp;
        }
        return total - maxS2 * 2;
    }
}

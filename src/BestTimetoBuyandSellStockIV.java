import java.util.Arrays;

public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/ 188
        int l = prices.length;
        if (l <= 1 || k <= 0) return 0;

        int profit = 0;
        if (k >= l / 2) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < l - 1; i++) {
                if (prices[i] < prices[i + 1]) {
                    profit += prices[i + 1] - prices[i];
                }
            }
            return profit;
        }

        int[] buy = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);

        int[] sell = new int[k];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < k; j++) {
                buy[j] = Math.max(buy[j], j == 0 ? -prices[i] : sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k - 1];
    }
}

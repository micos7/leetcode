public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/submissions/ 309
        int l = prices.length;
        if (l < 2) {
            return 0;
        }
        int[] profit = new int[l];
        int[] buy = new int[l];

        buy[0] = -prices[0];
        buy[1] = -Math.min(prices[0], prices[1]);

        profit[1] = Math.max(0, buy[0] + prices[1]);

        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], profit[i - 2] - prices[i]);
            profit[i] = Math.max(profit[i - 1], buy[i - 1] + prices[i]);
        }

        return profit[l - 1];
    }
}

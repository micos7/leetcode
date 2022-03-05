public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/ 123
        int max1 = 0;
        int min1 = Integer.MAX_VALUE;
        int max2 = 0;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            min1 = Math.min(min1, prices[i]);
            max1 = Math.max(max1, prices[i] - min1);
            min2 = Math.min(min2, prices[i] - max1);
            max2 = Math.max(max2, prices[i] - min2);
        }
        return max2;
    }
}

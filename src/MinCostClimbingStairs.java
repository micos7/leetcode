public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        //https://leetcode.com/problems/min-cost-climbing-stairs/ 746
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 2], cost[i - 1]);
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}

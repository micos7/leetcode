import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {
//https://leetcode.com/problems/minimum-cost-for-tickets/ 983
    public int mincostTickets(int[] days, int[] costs) {
        int max = days[days.length-1];
        Set<Integer> s = new HashSet<>();
        for(int i:days)
            s.add(i);

        int[] dp = new int[max+1];

        for(int i=1;i<dp.length;i++){
            int cost1 = dp[i-1];
            int cost7 = (i-7) > 0 ? dp[i-7] : 0;
            int cost30 = (i-30) > 0 ? dp[i-30]  : 0;
            if(s.contains(i)){
                dp[i] = Math.min(cost1+costs[0], Math.min(cost7 + costs[1], cost30 + costs[2]));
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}

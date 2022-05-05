import java.util.Arrays;

public class MinimumConsecutiveCardstoPickUp {
    public int minimumCardPickup(int[] cards) {
        //https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/ 2260
        int[] index = new int[1000001];
        Arrays.fill(index,-1);
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<cards.length;i++){
            if(index[cards[i]] != -1){
                ans = Math.min(ans, i-index[cards[i]]+1);
            }

            index[cards[i]] = i;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

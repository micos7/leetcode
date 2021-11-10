import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        //https://leetcode.com/problems/koko-eating-bananas/ 875
        int left = 1,right = Arrays.stream(piles).max().getAsInt();
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canEat(piles,mid,h)){
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    private boolean canEat(int[] piles,int k,int h){
        int hours = 0;
        for(int p: piles){
            hours += p/k;
            if(p% k !=0) hours += 1;
        }

        return hours <= h;
    }
}

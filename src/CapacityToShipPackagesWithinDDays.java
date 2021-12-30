public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        //https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/ 1011
        int min=0,max= 0;
        for(int w:weights){
            min = Math.max(min,w);
            max+=w;
        }

        while(min < max){
            int mid = min + (max-min)/2;
            int day =1,curWeight = 0;
            for(int w:weights){
                if(curWeight + w > mid){
                    day++;
                    curWeight = 0;
                }
                curWeight+=w;
            }
            if(day > days){
                min = mid+1;
            }else{
                max= mid;
            }
        }

        return min;
    }
}

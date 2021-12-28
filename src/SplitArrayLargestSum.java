public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        //https://leetcode.com/problems/split-array-largest-sum/ 410
        int max =0,sum =0;
        for(int n:nums){
            max = Math.max(n,max);
            sum+=n;
        }
        int left = max,right = sum;
        while(left < right){
            int mid = left + (right - left)/2;
            int parts = split(nums,mid);
            if(parts > m){
                left = mid +1;
            }else{
                right = mid;
            }
        }

        return left;
    }

    private int split(int[] nums,int weight){
        int curNum =1,curWeight = 0;
        for(int n:nums){
            if(curWeight + n > weight){
                curNum++;
                curWeight = 0;
            }
            curWeight+=n;
        }
        return curNum;
    }
}

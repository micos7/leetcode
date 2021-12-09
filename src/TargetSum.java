import java.util.HashMap;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        //https://leetcode.com/problems/target-sum/submissions/ 494
        HashMap<String,Integer> hm = new HashMap<>();
        return helper(nums,0,0,target,hm);
    }

    private int helper(int[] nums,int pos,int sum,int target,HashMap<String,Integer> hm){
        if(nums.length == pos){
            return sum == target ? 1 : 0;
        }
        String key = pos + " " + sum;
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        int val =  helper(nums,pos+1,sum -nums[pos],target,hm)+
                helper(nums,pos+1,sum + nums[pos],target,hm);

        hm.put(key,val);
        return val;
    }
}

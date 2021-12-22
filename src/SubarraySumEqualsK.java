import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        //https://leetcode.com/problems/subarray-sum-equals-k/ 560
        int count =0,sum = 0;
        HashMap<Integer,Integer> h = new HashMap<>();
        h.put(0,1);
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
            if(h.containsKey(sum-k)){
                count+= h.get(sum-k);
            }
            h.put(sum,h.getOrDefault(sum,0)+1);
        }

        return count;
    }
}

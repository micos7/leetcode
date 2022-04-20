import java.util.HashMap;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        //https://leetcode.com/problems/continuous-subarray-sum/ 523
        HashMap<Integer, Integer> h = new HashMap<>();
        int total = 0;
        h.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            int remainder = total % k;
            h.putIfAbsent(remainder, i);
            if (i - h.get(remainder) > 1) return true;
        }

        return false;
    }
}

import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        //https://leetcode.com/problems/contiguous-array/ 525
        HashMap<Integer, Integer> h = new HashMap<>();
        int bal = 0, ans = 0;
        h.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            bal += nums[i] == 0 ? -1 : 1;
            if (h.containsKey(bal)) {
                ans = Math.max(ans, i - h.get(bal));
            } else {
                h.put(bal, i);
            }
        }
        return ans;
    }
}

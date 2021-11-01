import java.util.HashMap;

public class NRepeatedElementinSize2NArray {
    public int repeatedNTimes(int[] nums) {
        //https://leetcode.com/problems/n-repeated-element-in-size-2n-array/ 961
        HashMap<Integer, Integer> h = new HashMap<>();

        for (int n : nums) {
            if (h.get(n) != null && h.get(n) == nums.length / 2) {
                return n;
            } else {
                h.put(n, h.getOrDefault(n, 1) + 1);
            }
        }
        return -1;
    }
}

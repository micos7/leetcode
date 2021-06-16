import java.util.*;

class twoSum {
    public int[] twoSum(int[] nums, int target) {
        Map < Integer, Integer > m = new HashMap < > ();
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (m.containsKey(remainder)) {
                return new int[] {
                        i,
                        m.get(remainder)
                };
            }
            m.put(nums[i], i);
        }
        return new int[] {
                -1, -1
        };
    }
}
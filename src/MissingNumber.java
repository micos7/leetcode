import java.util.HashSet;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        //https://leetcode.com/problems/missing-number/ 268
        HashSet<Integer> hs = new HashSet<Integer>();

        for (int i : nums) {
            hs.add(i);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!hs.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}

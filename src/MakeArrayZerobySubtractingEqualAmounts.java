import java.util.HashSet;
import java.util.Set;

public class MakeArrayZerobySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        //https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/ 2357
        Set<Integer> h = new HashSet<>();
        for (int n : nums) {
            if (n > 0) {
                h.add(n);
            }
        }

        return h.size();
    }
}

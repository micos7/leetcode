import java.util.Arrays;

public class MaximumConsecutiveFloorsWithoutSpecialFloors {
    public int maxConsecutive(int bottom, int top, int[] special) {
        //https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/ 2274
        Arrays.sort(special);
        int start = bottom;
        int end = top;
        int ans = 0;
        for (int i = 0; i < special.length; i++) {
            int index = special[i];
            int diff = index - start;
            ans = Math.max(ans, diff);
            start = index + 1;
        }

        ans = Math.max(ans, end - special[special.length - 1]);
        return ans;
    }
}

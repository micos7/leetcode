import java.util.ArrayList;
import java.util.List;

public class MaximumSplitofPositiveEvenIntegers {
    public List<Long> maximumEvenSplit(long finalSum) {
        //https://leetcode.com/problems/maximum-split-of-positive-even-integers/ 2178
        List<Long> ans = new ArrayList<>();
        Long cur = (long) 2;
        Long rem = (long) finalSum;
        if (finalSum % 2 == 0) {
            while (rem - cur > cur) {
                ans.add(cur);
                rem -= cur;
                cur += 2;
            }
            ans.add(rem);
        }

        return ans;
    }
}

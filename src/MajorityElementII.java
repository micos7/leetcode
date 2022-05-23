import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        //https://leetcode.com/problems/majority-element-ii/ 229
        Integer t = null, j = null, tCount = 0, jCount = 0;
        for (Integer num : nums) {
            if (num.equals(t)) {
                tCount++;
            } else if (num.equals(j)) {
                jCount++;
            } else if (tCount == 0) {
                t = num;
                tCount = 1;
            } else if (jCount == 0) {
                j = num;
                jCount = 1;
            } else {
                tCount--;
                jCount--;
            }
        }

        tCount = 0;
        jCount = 0;
        for (int num : nums) {
            if (num == t) {
                tCount++;
            } else if (num == j) {
                jCount++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (tCount > nums.length / 3) {
            ans.add(t);
        }
        if (jCount > nums.length / 3) {
            ans.add(j);
        }

        return ans;
    }
}

import java.util.HashSet;

public class LongestConsecutiveSequence {
    //https://leetcode.com/problems/longest-consecutive-sequence/ 128
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int max = 0;

        for (int num : nums) {
            hs.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            int cur_num = nums[i];
            int cur_seq = 1;
            if (!hs.contains(cur_num - 1)) {
                while (hs.contains(cur_num + 1)) {
                    cur_num += 1;
                    cur_seq += 1;
                }
                max = Math.max(max, cur_seq);
            }


        }

        return max;
    }
}

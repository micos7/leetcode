public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        //https://leetcode.com/problems/find-pivot-index/ 724
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int left_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) left_sum += nums[i - 1];
            if (total - left_sum - nums[i] == left_sum) return i;
        }


        return -1;

    }
}

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //https://leetcode.com/problems/first-missing-positive/ 41
        int n = nums.length, containsOne = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                containsOne = 1;
            } else if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        if (containsOne == 0) return 1;

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = -nums[index];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }

        return n + 1;
    }
}

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        //https://leetcode.com/problems/next-permutation/ 31
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int i) {
        int end = nums.length - 1;
        while (i < end) {
            swap(nums, i, end);
            i++;
            end--;
        }
    }
}

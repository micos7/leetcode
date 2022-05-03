public class SortColors {
    public void sortColors(int[] nums) {
        //https://leetcode.com/problems/sort-colors/ 75
        int left = 0;
        int right = nums.length - 1;
        int index = 0;

        while (index <= right && left < right) {
            if (nums[index] == 0) {
                nums[index] = nums[left];
                nums[left] = 0;
                left++;
                index++;
            } else if (nums[index] == 2) {
                nums[index] = nums[right];
                nums[right] = 2;
                right--;
            } else {
                index++;
            }
        }
    }
}

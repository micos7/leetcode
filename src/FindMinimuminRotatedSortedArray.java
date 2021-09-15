public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ 153
        int min = Integer.MIN_VALUE;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}

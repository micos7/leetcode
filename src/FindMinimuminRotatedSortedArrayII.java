public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/ 154
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == nums[high]) {
                high = high - 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return nums[low];
    }
}

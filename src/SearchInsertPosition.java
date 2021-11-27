public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        //https://leetcode.com/problems/search-insert-position/ 35
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}

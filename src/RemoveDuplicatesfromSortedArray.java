public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        //https://leetcode.com/problems/remove-duplicates-from-sorted-array/ 26
        int idx = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[idx++] = nums[i + 1];
            }
        }
        return idx;
    }
}

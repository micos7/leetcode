public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/ 80
        int j = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[j - 2] < nums[i]) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}

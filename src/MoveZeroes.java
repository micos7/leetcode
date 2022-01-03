public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        //https://leetcode.com/problems/move-zeroes/ 283
        int i = 0, j = 0;

        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        for (; i < nums.length; i++) {
            nums[i] = 0;
        }


    }
}

public class JumpGame {
    public boolean canJump(int[] nums) {
        //https://leetcode.com/problems/jump-game/ 55
        int lastIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastIndex) {
                lastIndex = i;
            }
        }

        return lastIndex == 0;
    }
}

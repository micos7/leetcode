public class JumpGameII {
    public int jump(int[] nums) {
        //https://leetcode.com/problems/jump-game-ii/ 45
        int jumps = 0, curEnd=0,nextEnd = 0;
        for(int i = 0;i<nums.length-1;i++){
            nextEnd = Math.max(nextEnd,i+nums[i]);
            if(i == curEnd){
                jumps++;
                curEnd = nextEnd;
            }
        }
        return jumps;
    }
}

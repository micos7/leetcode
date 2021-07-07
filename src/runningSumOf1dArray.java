public class runningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        //https://leetcode.com/problems/running-sum-of-1d-array/ 1480
        int sum = 0;
        int[] response = new int[nums.length];
        for(int j =0;j<nums.length;j++){
            sum += nums[j];
            response[j] = sum;
        }
        return response;
    }
}

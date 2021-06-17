public class runningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] response = new int[nums.length];
        for(int j =0;j<nums.length;j++){
            sum += nums[j];
            response[j] = sum;
        }
        return response;
    }
}

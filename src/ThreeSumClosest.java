import java.util.Arrays;

public class ThreeSumClosest {
    //https://leetcode.com/problems/3sum-closest/ 16
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int tempSum = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int runningSum = nums[left] + nums[right] + nums[i];
                if (runningSum <= target) {
                    left++;
                } else {
                    right--;
                }

                if (Math.abs(runningSum - target) < Math.abs(tempSum - target)) {
                    tempSum = runningSum;
                }
            }

        }

        return tempSum;
    }
}

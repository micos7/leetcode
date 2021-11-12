public class MinimumValuetoGetPositiveStepbyStepSum {
    public int minStartValue(int[] nums) {
        //https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/ 1413
        int min = 0;
        int sum = 0;
        for(int n:nums){
            sum+=n;
            min = Math.min(min,sum);
        }
        return min < 0 ? Math.abs(min)+1 : 1;
    }
}

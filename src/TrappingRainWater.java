public class TrappingRainWater {
    public int trap(int[] height) {
        //https://leetcode.com/problems/trapping-rain-water/ 42
        int max = 0, n = height.length;
        for (int i = 0; i < n; i++) {
            if (height[max] < height[i]) {
                max = i;
            }
        }

        int sum = 0;
        int maxLeft = 0;
        for (int i = 0; i < max; i++) {
            if (height[maxLeft] < height[i]) {
                maxLeft = i;
            }
            sum += Math.min(height[max], height[maxLeft]) - height[i];
        }

        int maxRight = n - 1;
        for (int i = n - 1; i > max; i--) {
            if (height[maxRight] < height[i]) {
                maxRight = i;
            }
            sum += Math.min(height[max], height[maxRight]) - height[i];
        }

        return sum;
    }
}

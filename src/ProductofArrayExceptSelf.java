public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        //https://leetcode.com/problems/product-of-array-except-self/ 238
        int N = nums.length;

        int[] left = new int[N];
        int[] right = new int[N];

        int[] answer = new int[N];

        left[0] = 1;
        right[N - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        for (int i = N - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        for (int i = 0; i < N; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }
}

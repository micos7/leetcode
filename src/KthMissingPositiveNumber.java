public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        //https://leetcode.com/problems/kth-missing-positive-number/ 1539
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                k++;
            } else {
                break;
            }
        }

        return k;
    }
}

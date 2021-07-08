public class KthSmallestElementinASortedMatrix {
    //https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/ 378
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, low = matrix[0][0], high = matrix[n - 1][n - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = lower(matrix, mid);
            if (count < k) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public int lower(int[][] matrix, int target) {
        int count = 0, L = matrix.length, i = L - 1, j = 0;
        while (i >= 0 && j < L) {
            if (matrix[i][j] > target) i--;
            else {
                count = count + i + 1;
                j++;
            }
        }
        return count;
    }
}

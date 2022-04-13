public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //https://leetcode.com/problems/search-a-2d-matrix/ 74
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            }
        }
        return false;
    }
}

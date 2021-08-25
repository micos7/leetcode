public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        //https://leetcode.com/problems/set-matrix-zeroes/ 73
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                zeroCol(matrix, j, m, n);
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                zeroRow(matrix, i, m, n);
            }
        }

        if (firstRowZero) {
            zeroRow(matrix, 0, m, n);
        }
        if (firstColZero) {
            zeroCol(matrix, 0, m, n);
        }


    }

    public void zeroRow(int[][] matrix, int index, int m, int n) {
        for (int col = 0; col < n; col++) {
            matrix[index][col] = 0;
        }
    }

    public void zeroCol(int[][] matrix, int index, int m, int n) {
        for (int row = 0; row < m; row++) {
            matrix[row][index] = 0;
        }
    }

}

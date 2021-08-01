import java.util.Arrays;

public class DetermineWhetherMatrixCanBeObtainedByRotation {
    //https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/ 1886
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }

    private void rotate(int[][] mat) {
        int m = mat.length;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][m - 1 - j];
                mat[i][m - 1 - j] = temp;
            }
        }
    }

}

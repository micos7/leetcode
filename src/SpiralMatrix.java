import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        //https://leetcode.com/problems/spiral-matrix/ 54
        List<Integer> m = new ArrayList<>();
        if (matrix.length == 0 || matrix == null) {
            return m;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int size = matrix.length * matrix[0].length;


        while (m.size() < size) {
            for (int i = left; i <= right && m.size() < size; i++) {
                m.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom && m.size() < size; i++) {
                m.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && m.size() < size; i--) {
                m.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top && m.size() < size; i--) {
                m.add(matrix[i][left]);
            }
            left++;
        }

        return m;
    }
}

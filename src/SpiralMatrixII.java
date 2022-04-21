public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        //https://leetcode.com/problems/spiral-matrix-ii/ 59
        int[][] ans = new int[n][n];
        int r = 0, rr = n - 1;
        int c = 0, cc = n - 1;
        int val = 1;

        while (r <= rr && c <= cc) {
            for (int i = c; i <= cc; i++) ans[r][i] = val++;

            for (int i = r + 1; i <= rr; i++) ans[i][cc] = val++;

            for (int i = cc - 1; i > c; i--) ans[rr][i] = val++;

            for (int i = rr; i > r; i--) ans[i][c] = val++;


            r++;
            rr--;
            c++;
            cc--;
        }

        return ans;
    }
}

public class LongestIncreasingPathinaMatrix {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        //https://leetcode.com/problems/longest-increasing-path-in-a-matrix/ 329
        if (matrix == null || matrix.length == 0) return 0;
        int r = matrix.length, c = matrix[0].length;
        int[][] memo = new int[r][c];
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int path = dfs(matrix, r, c, i, j, memo);
                ans = Math.max(ans, path);
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int m, int n, int i, int j, int[][] memo) {
        if (memo[i][j] > 0) return memo[i][j];
        int max = 0;
        for (int[] d : dirs) {
            int x = d[0] + i, y = d[1] + j;
            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, dfs(matrix, m, n, x, y, memo));

            }
        }
        memo[i][j] = max + 1;
        return max + 1;
    }
}

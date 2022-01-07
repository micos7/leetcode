public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        //https://leetcode.com/problems/minimum-falling-path-sum/ 931
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i][j]);
                }
                dp[i][j] += matrix[i][j];
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int d : dp[n - 1]) {
            ans = Math.min(ans, d);
        }

        return ans;
    }
    //second version
    int n;
    Integer[][] memo;
    int[][] matrix;

    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        this.matrix = matrix;
        memo = new Integer[n][n];
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, dfs(0, i));
        }
        return minSum;
    }

    private int dfs(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return Integer.MAX_VALUE;
        }

        if (row == n - 1) {
            return matrix[row][col];
        }

        if (memo[row][col] != null) {
            return memo[row][col];
        }

        int bottom = dfs(row + 1, col);
        int bottomLeft = dfs(row + 1, col - 1);
        int bottomRight = dfs(row + 1, col + 1);

        int minSum = Math.min(bottom, Math.min(bottomLeft, bottomRight));

        memo[row][col] = minSum + matrix[row][col];

        return memo[row][col];
    }
}

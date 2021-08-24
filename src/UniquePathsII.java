public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //https://leetcode.com/problems/unique-paths-ii/ 63
        if (obstacleGrid[0][0] == 1) return 0;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0 || j == 0) {
                    if (obstacleGrid[i][j] == 1 || (i != 0 && obstacleGrid[i - 1][j] == 0) || (j != 0 && obstacleGrid[i][j - 1] == 0)) {
                        obstacleGrid[i][j] = 0;
                    } else {
                        obstacleGrid[i][j] = 1;
                    }
                } else {
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}

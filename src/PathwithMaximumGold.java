public class PathwithMaximumGold {
    int ans = 0;
    public int getMaximumGold(int[][] grid) {
        //https://leetcode.com/problems/path-with-maximum-gold/ 1219
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    rec(i, j, 0, visited, grid);
                }
            }
        }
        return ans;
    }

    private void rec(int i, int j, int gold, boolean[][] visited, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) return;

        gold += grid[i][j];
        ans = Math.max(ans, gold);
        visited[i][j] = true;
        rec(i + 1, j, gold, visited, grid);
        rec(i - 1, j, gold, visited, grid);
        rec(i, j + 1, gold, visited, grid);
        rec(i, j - 1, gold, visited, grid);
        visited[i][j] = false;
    }
}

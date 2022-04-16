public class CountSubIslands {
    int flag = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        //https://leetcode.com/problems/count-sub-islands/ 1905
        int r = grid2.length;
        int c = grid2[0].length;
        int count = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (grid2[i][j] == 1) {
                    flag = 1;
                    dfs(grid1, grid2, i, j);
                    count += flag;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length || grid2[i][j] == 0) {
            return;
        }

        if (grid1[i][j] == 0) {
            flag = 0;
        }
        grid2[i][j] = 0;

        dfs(grid1, grid2, i + 1, j);
        dfs(grid1, grid2, i - 1, j);
        dfs(grid1, grid2, i, j + 1);
        dfs(grid1, grid2, i, j - 1);

    }
}

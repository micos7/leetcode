public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        //https://leetcode.com/problems/number-of-islands 200
        int count = 0;
        if (grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    rec(grid, i, j);
                    count++;
                }

            }
        }

        return count;
    }


    public void rec(char[][] grid, int i, int j) {
        if (j < 0 || i < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';

        rec(grid, i + 1, j);
        rec(grid, i - 1, j);
        rec(grid, i, j + 1);
        rec(grid, i, j - 1);
    }
}

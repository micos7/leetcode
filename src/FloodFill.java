public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //https://leetcode.com/problems/flood-fill/ 733
        int color = image[sr][sc];
        rec(image, sr, sc, newColor, color);
        return image;
    }

    private void rec(int[][] grid, int i, int j, int newColor, int color) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == newColor || grid[i][j] != color)
            return;

        grid[i][j] = newColor;

        rec(grid, i + 1, j, newColor, color);
        rec(grid, i - 1, j, newColor, color);
        rec(grid, i, j + 1, newColor, color);
        rec(grid, i, j - 1, newColor, color);
    }
}

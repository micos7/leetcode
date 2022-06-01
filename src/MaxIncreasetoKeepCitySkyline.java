public class MaxIncreasetoKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        //https://leetcode.com/problems/max-increase-to-keep-city-skyline/ 807
        int r = grid.length, c = grid[0].length;

        int[] rows = new int[r];
        int[] cols = new int[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                rows[i] = Math.max(rows[i], grid[i][j]);
                cols[j] = Math.max(cols[j], grid[i][j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans += Math.min(rows[i], cols[j]) - grid[i][j];
            }
        }
        return ans;
    }
}

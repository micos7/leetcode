import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinaGridwithObstaclesElimination {

    public int shortestPath(int[][] grid, int k) {
        //https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/ 1293
        int r = grid.length, c = grid[0].length;
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        boolean[][][] v = new boolean[r][c][k + 1];
        int ans = 0;
        if (grid[r - 1][c - 1] == 1) return -1;
        Queue<int[]> q = new LinkedList();

        q.offer(new int[]{0, 0, k});


        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == r - 1 && cur[1] == c - 1) return ans;
                for (int[] d : dir) {
                    int i = cur[0] + d[0];
                    int j = cur[1] + d[1];
                    int obs = cur[2];

                    if (i >= 0 && i < r && j >= 0 && j < c) {
                        if (grid[i][j] == 0 && !v[i][j][obs]) {
                            q.offer(new int[]{i, j, obs});
                            v[i][j][obs] = true;
                        } else if (grid[i][j] == 1 && obs > 0 && !v[i][j][obs - 1]) {
                            q.offer(new int[]{i, j, obs - 1});
                            v[i][j][obs - 1] = true;
                        }
                    }
                }
            }
            ans++;
        }

        return -1;
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //https://leetcode.com/problems/shortest-path-in-binary-matrix/ 1091
        if (grid[0][0] == 1) return -1;
        int r = grid.length, c = grid[0].length;
        int[][] dir = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, -1}};
        int cells = 0;
        Queue<int[]> q = new LinkedList();
        boolean[][] v = new boolean[r][c];
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == r - 1 && cur[1] == c - 1) return cells + 1;
                for (int[] d : dir) {
                    int i = cur[0] + d[0];
                    int j = cur[1] + d[1];
                    if (i >= 0 && i < r && j >= 0 && j < c) {
                        if (grid[i][j] == 0 && !v[i][j]) {
                            q.offer(new int[]{i, j});
                            v[i][j] = true;
                        }
                    }
                }
            }
            cells++;
        }

        return -1;
    }
}

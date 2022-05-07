import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        //https://leetcode.com/problems/making-a-large-island/ 827
        if (grid == null || grid.length == 0) return 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int ans = 0, islandId = 2, r = grid.length, c = grid[0].length;
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    int size = getSize(grid, i, j, islandId);
                    ans = Math.max(ans, size);
                    h.put(islandId++, size);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> s = new HashSet<>();
                    for (int[] d : dirs) {
                        int x = d[0] + i, y = d[1] + j;
                        if (x > -1 && y > -1 && x < r && y < c && grid[x][y] != 0) {
                            s.add(grid[x][y]);
                        }
                    }

                    int sum = 1;
                    for (int n : s) {
                        int val = h.get(n);
                        sum += val;
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }

        return ans;
    }

    private int getSize(int[][] grid, int i, int j, int islandId) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return 0;
        grid[i][j] = islandId;
        int left = getSize(grid, i, j - 1, islandId);
        int right = getSize(grid, i, j + 1, islandId);
        int up = getSize(grid, i - 1, j, islandId);
        int down = getSize(grid, i + 1, j, islandId);

        return left + right + up + down + 1;
    }
}

import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsofFarmland {
    //https://leetcode.com/problems/find-all-groups-of-farmland/ 1992
    private int ii, jj;

    public int[][] findFarmland(int[][] land) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ii = i;
                    jj = j;
                    dfs(land, i, j);
                    temp.add(ii);
                    temp.add(jj);
                    ans.add(temp);
                }

            }
        }
        int[][] res = new int[ans.size()][4];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;
    }

    private void dfs(int[][] land, int i, int j) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] == 0) return;
        land[i][j] = 0;
        ii = Math.max(i, ii);
        jj = Math.max(jj, j);
        dfs(land, i + 1, j);
        dfs(land, i - 1, j);
        dfs(land, i, j + 1);
        dfs(land, i, j - 1);
    }
}

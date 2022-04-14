import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        //https://leetcode.com/problems/flower-planting-with-no-adjacent/ 1042
        int[] ans = new int[n];

        HashMap<Integer, Set<Integer>> h = new HashMap<>();

        for (int i = 0; i < n; i++) {
            h.put(i, new HashSet<Integer>());
        }

        for (int[] p : paths) {
            h.get(p[0] - 1).add(p[1] - 1);
            h.get(p[1] - 1).add(p[0] - 1);
        }

        for (int i = 0; i < n; i++) {
            int[] types = new int[5];

            for (int j : h.get(i)) types[ans[j]] = 1;

            for (int j = 4; j > 0; j--) {
                if (types[j] == 0) {
                    ans[i] = j;
                }
            }
        }

        return ans;
    }
}

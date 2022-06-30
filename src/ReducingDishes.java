import java.util.Arrays;

public class ReducingDishes {
    public int maxSatisfaction(int[] satisfaction) {
        //https://leetcode.com/problems/reducing-dishes/ 1402
        Arrays.sort(satisfaction);
        int ans = 0, total = 0, n = satisfaction.length;
        for (int i = n - 1; i >= 0 && satisfaction[i] > -total; --i) {
            total += satisfaction[i];
            ans += total;
        }
        return ans;
    }
}

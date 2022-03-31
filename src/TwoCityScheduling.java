import java.util.Arrays;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        //https://leetcode.com/problems/two-city-scheduling/ 1029
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1] - (b[0] - b[1]));
        });
        int total = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                total += costs[i][0];
            } else {
                total += costs[i][1];
            }
        }
        return total;
    }
}

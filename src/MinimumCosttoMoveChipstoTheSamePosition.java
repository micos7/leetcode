public class MinimumCosttoMoveChipstoTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        //https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/ 1217
        int even = 0, odd = 0;

        for (int p : position) {
            if (p % 2 != 0) odd++;
            else even++;
        }

        return Math.min(odd, even);
    }
}

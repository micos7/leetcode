public class New21Game {
    public double new21Game(int n, int k, int maxPts) {
        //https://leetcode.com/problems/new-21-game/ 837
        if (k == 0) return 1;

        int maxPoint = k + maxPts - 1;

        double[] probability = new double[maxPoint + 1];

        probability[0] = 1;
        for (int i = 1; i <= maxPoint; i++) {
            for (int w = 1; w <= maxPts; w++) {
                if (i - w >= 0 && i - w < k)
                    probability[i] += probability[i - w] * 1 / maxPts;
            }
        }

        double targetProbability = 0;
        for (int i = k; i <= n; i++) {
            targetProbability += probability[i];
        }

        return targetProbability;
    }
}

public class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        //https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/ 1423
        int n = cardPoints.length, totalSum = 0, minSubarray = 0;

        for (int i = 0, currSum = 0; i < n; i++) {
            totalSum += cardPoints[i];
            currSum += cardPoints[i];
            if (i < n - k) minSubarray += cardPoints[i];
            else {
                currSum -= cardPoints[i - (n - k)];
                minSubarray = Math.min(minSubarray, currSum);
            }
        }

        return totalSum - minSubarray;
    }
}

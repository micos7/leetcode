import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {
    public boolean isPossible(int[] target) {
        //https://leetcode.com/problems/construct-target-array-with-multiple-sums/ 1354
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        long totalSum = 0l;

        for (int el : target) {
            pq.add(el);
            totalSum = totalSum + el;
        }

        while (!pq.isEmpty()) {
            int maxEl = pq.poll();
            long remaingTotal = totalSum - maxEl;

            if (maxEl == 1 || remaingTotal == 1) {
                return true;
            }
            if (remaingTotal == 0 || maxEl < remaingTotal) {
                return false;
            }

            int updatedMax = (int) (maxEl % remaingTotal);

            if (updatedMax == 0) {
                return false;
            }

            maxEl = updatedMax;
            pq.offer(maxEl);
            totalSum = updatedMax + remaingTotal;
        }

        return true;
    }
}

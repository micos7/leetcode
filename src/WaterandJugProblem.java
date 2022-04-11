import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WaterandJugProblem {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        //https://leetcode.com/problems/water-and-jug-problem/ 365
        if (jug1Capacity + jug2Capacity < targetCapacity) return false;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int[] dirs = {jug1Capacity, -jug1Capacity, jug2Capacity, -jug2Capacity};
        Set<Integer> v = new HashSet<>();
        v.add(0);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == targetCapacity) return true;
            for (int d : dirs) {
                int total = d + cur;
                if (total == targetCapacity) return true;
                if (total < 0 || total > jug1Capacity + jug2Capacity) continue;
                if (!v.contains(total)) {
                    v.add(total);
                    q.offer(total);
                }
            }
        }
        return false;
    }
}

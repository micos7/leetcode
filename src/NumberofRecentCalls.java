import java.util.LinkedList;
import java.util.Queue;

public class NumberofRecentCalls {
    //https://leetcode.com/problems/number-of-recent-calls/ 933
    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000) {
            q.poll();
        }
        return q.size();
    }
}
}

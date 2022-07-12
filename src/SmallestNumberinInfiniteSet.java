import java.util.Arrays;

public class SmallestNumberinInfiniteSet {
    int head;
    boolean[] visited;

    SmallestInfiniteSet() {
        //https://leetcode.com/problems/smallest-number-in-infinite-set/ 2336
        visited = new boolean[1001];
        Arrays.fill(visited, true);
        head = 1;
    }

    int popSmallest() {
        int ans = head;
        visited[ans] = false;
        for (int i = head + 1; i <= 1000; i++) {
            if (visited[i]) {
                head = i;
                break;
            }
        }
        return ans;
    }

    void addBack(int num) {
        if (visited[num])
            return;

        visited[num] = true;

        if (num < head) {
            head = num;
        }
    }
}

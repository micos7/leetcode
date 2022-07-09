import java.util.PriorityQueue;

public class JumpGameVI {
    public int maxResult(int[] nums, int k) {
        //https://leetcode.com/problems/jump-game-vi/ 1696
        int n = nums.length;
        int max = nums[0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        pq.offer(new int[]{0, nums[0]});

        for (int i = 1; i < n; i++) {

            while (i - pq.peek()[0] > k) {
                pq.poll();
            }

            int[] top = pq.peek();

            max = nums[i] + top[1];

            pq.offer(new int[]{i, max});

        }

        return max;
    }
}

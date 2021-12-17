import java.util.PriorityQueue;
import java.util.Set;

public class FindSubsequenceofLengthKWiththeLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        //https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/ 2099
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        Set<Integer> set = new HashSet<>();
        int[] res = new int[k];

        while (!pq.isEmpty()) {
            int[] max = pq.poll();
            set.add(max[1]);

        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                res[j] = nums[i];
                j++;
            }
        }

        return res;


    }
}

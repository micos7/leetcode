import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //https://leetcode.com/problems/find-k-pairs-with-smallest-sums/ 373
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<List<Integer>> ans = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return ans;

        for (int i = 0; i < nums1.length && i < k; i++)
            pq.offer(new int[]{nums1[i], nums2[0], 0});

        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            ans.add(Arrays.asList(cur[0], cur[1]));
            if (cur[2] == nums2.length - 1) continue;
            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return ans;
    }
}

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        //https://leetcode.com/problems/kth-largest-element-in-an-array/ 215
        PriorityQueue<Integer> p = new PriorityQueue();
        for (int n : nums) {
            p.add(n);
            if (p.size() > k) {
                p.remove();
            }
        }
        return p.remove();
    }
}

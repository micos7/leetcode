import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //https://leetcode.com/problems/next-greater-element-i/ 496
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        for (int n : nums2) {
            while (!s.isEmpty() && s.peek() < n) {
                hm.put(s.pop(), n);
            }
            s.push(n);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = hm.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}

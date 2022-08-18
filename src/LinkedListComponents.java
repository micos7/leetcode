import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
    public int numComponents(ListNode head, int[] nums) {
        //https://leetcode.com/problems/linked-list-components/
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        int ans = 0;
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) ans++;
            head = head.next;
        }
        return ans;
    }
}

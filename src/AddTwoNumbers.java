public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //https://leetcode.com/problems/add-two-numbers/ 2
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1val = (l1 != null) ? l1.val : 0;
            int l2val = (l2 != null) ? l2.val : 0;
            int sum = l1val + l2val + carry;
            carry = sum / 10;
            int last_digit = sum % 10;

            ListNode new_node = new ListNode(last_digit);
            ans.next = new_node;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            ans = ans.next;
        }

        if (carry > 0) {
            ListNode new_node = new ListNode(carry);
            ans.next = new_node;
            ans = ans.next;
        }

        return dummy.next;
    }
}

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        //https://leetcode.com/problems/swap-nodes-in-pairs/ 24
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode cur = temp;

        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            cur.next = second;
            cur.next.next = first;
            cur = cur.next.next;
        }

        return temp.next;
    }
}

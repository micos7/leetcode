public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        //https://leetcode.com/problems/remove-linked-list-elements/ 203
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy.next;
        while(curr != null){
            while(curr != null && curr.val == val){
                prev.next = curr.next;
                curr = curr.next;
            }
            prev= prev.next;
            if(curr != null){
                curr = curr.next;
            }

        }
        return dummy.next;

    }
}

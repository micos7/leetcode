public class ReorderList {
    //https://leetcode.com/problems/reorder-list/ 143
    public void reorderList(ListNode head) {
        if(head == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        ListNode previous =null,current = slow, temp;
        while(current != null){
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        ListNode first = head, second = previous;
        while(second.next != null){
            temp = first.next;
            first.next = second;
            first = temp;
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}

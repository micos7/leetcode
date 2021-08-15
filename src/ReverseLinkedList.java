public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //https://leetcode.com/problems/reverse-linked-list/ 206
        Stack<ListNode> s = new Stack<ListNode>();

        while(head != null){
            s.push(head);
            head = head.next;
        }

        ListNode dummy = new ListNode(1);
        head = dummy;

        while(!s.isEmpty()){
            ListNode l = s.pop();
            head.next = new ListNode(l.val);
            head = head.next;
        }

        return dummy.next;
    }
}

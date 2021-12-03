public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        //https://leetcode.com/problems/odd-even-linked-list/ 328
        if(head==null){
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;

        ListNode evenHead = even;

        while(odd.next != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            if(odd != null){
                even.next = odd.next;
                even = even.next;
            }
        }

        odd.next = evenHead;

        return head;
    }
}

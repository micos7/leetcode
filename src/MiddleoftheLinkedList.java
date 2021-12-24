public class MiddleoftheLinkedList {
    int steps = 0;
    int middle = 0;
    public ListNode middleNode(ListNode head) {
        //https://leetcode.com/problems/middle-of-the-linked-list/ 876
        ListNode dummy = head;
        while(dummy != null){
            dummy = dummy.next;
            steps++;
        }
        middle = steps/2;
        while(middle>0){
            middle--;
            head = head.next;
        }

        return head;

    }
}

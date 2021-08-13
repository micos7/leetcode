public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        //https://leetcode.com/problems/merge-k-sorted-lists/ 23
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(ListNode head: lists){
            while(head != null){
                q.add(head.val);
                head = head.next;
            }

        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while(!q.isEmpty()){
            head.next = new ListNode(q.remove());
            head = head.next;
        }

        return dummy.next;
    }
}

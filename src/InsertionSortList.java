public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        //https://leetcode.com/problems/insertion-sort-list/ 147
        if(head == null || head.next == null){
            return head;
        }

        ListNode preInsert;
        ListNode toInsert;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val <= cur.next.val){
                cur = cur.next;
            }else{
                toInsert = cur.next;
                preInsert = dummy;
                while(preInsert.next.val < toInsert.val){
                    preInsert = preInsert.next;
                }

                cur.next = toInsert.next;
                toInsert.next = preInsert.next;
                preInsert.next = toInsert;
            }
        }
        return dummy.next;
    }
}

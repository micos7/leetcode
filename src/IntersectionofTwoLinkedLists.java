public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //https://leetcode.com/problems/intersection-of-two-linked-lists/ 160
        Set<ListNode> s = new HashSet();

        while (headA != null) {
            s.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (s.contains(headB)) return headB;
            headB = headB.next;
        }

        return null;

    }
}

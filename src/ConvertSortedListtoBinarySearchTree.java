public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        //https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/ 109
        if (head == null) return null;
        ListNode mid = mid(head);
        TreeNode root = new TreeNode(mid.val);

        if (head == mid) return root;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode mid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) prev.next = null;
        return slow;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode slow = head,fast = head.next;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next =null;

        TreeNode root = new TreeNode(mid.val);

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
}

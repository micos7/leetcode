public class PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/ 116
        if (root == null) return root;

        Node left = root;
        while (left.left != null) {
            Node head = left;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            left = left.left;
        }

        return root;
    }
}


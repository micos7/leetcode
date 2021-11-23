public class ConstructBinaryTreefromInorderandPostorderTraversal {
    int pos = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/ 106
        pos = postorder.length - 1;
        TreeNode root = makeTree(inorder,postorder,0, inorder.length-1);
        return root;
    }

    private TreeNode makeTree(int[] inorder, int[] postorder,int start,int end){
        if(pos < 0 || start > end){
            return null;
        }

        int val = postorder[pos];

        TreeNode node = new TreeNode(val);
        pos--;

        int i = start;
        for(i = start;i<end;i++){
            if(val == inorder[i]){
                break;
            }
        }

        TreeNode right = makeTree(inorder,postorder,i+1, end);
        TreeNode left = makeTree(inorder,postorder,start, i-1);

        node.right = right;
        node.left = left;
        return node;
    }
}

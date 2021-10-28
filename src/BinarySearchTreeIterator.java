import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {
    //https://leetcode.com/problems/binary-search-tree-iterator/
    List<Integer> l;
    int index;

    public BSTIterator(TreeNode root) {
        l= new ArrayList<>();
        index= 0;
        inOrder(root);
    }

    public int next() {
        return l.get(index++);
    }

    public boolean hasNext() {
        return index < l.size();
    }

    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        l.add(root.val);
        inOrder(root.right);
    }
}
}

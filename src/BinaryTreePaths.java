import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        //https://leetcode.com/problems/binary-tree-paths/ 257
        List<String> paths = new ArrayList<>();
        if(root == null){
            return paths;
        }

        traverse(root,"",paths);
        return paths;
    }

    private void traverse(TreeNode root,String temp,List<String> paths){
        temp+=root.val;
        if(root.left == null && root.right == null){
            paths.add(temp);
            return;
        }

        if(root.left != null){
            traverse(root.left,temp + "->" ,paths);
        }

        if(root.right != null){
            traverse(root.right,temp + "->" ,paths);
        }
    }
}

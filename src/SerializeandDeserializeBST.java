import java.util.LinkedList;

public class SerializeandDeserializeBST {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("*,");
            return;
        }

        sb.append(root.val);
        sb.append(",");
        buildString(root.left,sb);
        buildString(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> l = new LinkedList(Arrays.asList(data.split(",")));
        return decodeTree(l);
    }

    private TreeNode decodeTree(LinkedList<String> l){
        String first = l.removeFirst();
        if(first.equals("*")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(first));
        root.left = decodeTree(l);
        root.right = decodeTree(l);

        return root;
    }
}
}

public class CloneGraph {
    //https://leetcode.com/problems/clone-graph/ 133
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> hm = new HashMap<>();
        return cloneGraph(node, hm);
    }

    private Node cloneGraph(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) return map.get(node.val);
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        for (Node neighbor : node.neighbors) copy.neighbors.add(cloneGraph(neighbor, map));
        return copy;
    }
}

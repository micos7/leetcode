import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> m = new HashMap<>();

    int capacity;

    public LRUCache(int capacity) {
        //https://leetcode.com/problems/lru-cache/ 146
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (m.containsKey(key)) {
            Node data = m.get(key);
            remove(data);
            insert(data);

            return data.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            remove(m.get(key));
        }

        if (capacity == m.size()) {
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }

    public void remove(Node n) {
        m.remove(n.key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public void insert(Node n) {
        m.put(n.key, n);
        Node headNext = head.next;
        head.next = n;
        n.prev = head;
        headNext.prev = n;
        n.next = headNext;
    }

    class Node {
        Node prev, next;
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

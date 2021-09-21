public class ImplementTrie {
    class Trie {
    //https://leetcode.com/problems/implement-trie-prefix-tree/ 208
        private Node root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new Node('0');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node cur = root;
            for(int i =0;i< word.length();i++){
                char c = word.charAt(i);
                if(cur.children[c - 'a'] == null) cur.children[c- 'a'] = new Node(c);
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node node = getNode(word);
            return node != null && node.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return getNode(prefix) != null;
        }

        private Node getNode(String word){
            Node cur = root;
            for(int i = 0;i<word.length();i++){
                char c = word.charAt(i);
                if(cur.children[c -'a'] == null) return null;
                cur = cur.children[c - 'a'];
            }
            return cur;
        }

        class Node{
            public char c;
            public boolean isWord;
            public Node[] children;

            public Node(char c){
                this.c =c;
                isWord = false;
                children = new Node[26];
            }
        }
    }
}

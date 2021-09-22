public class DesignAddandSearchWordsDataStructure {
    //https://leetcode.com/problems/design-add-and-search-words-data-structure/ 211

    class Trie {
        Trie[] children;
        boolean isWord;

        public Trie() {
            children = new Trie[26];
            isWord = false;
        }
    }

    private Trie root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie cur = root;
        for (char c : word.toCharArray()) {
            int index = (int) (c - 'a');
            if (cur.children[index] == null) {
                cur.children[index] = new Trie();
            }

            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return find(word, root, 0);
    }

    private boolean find(String word, Trie cur, int index) {
        if (index == word.length()) {
            return cur.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null && find(word, cur.children[i], index + 1)) return true;

            }
            return false;
        } else {
            return cur.children[c - 'a'] != null && find(word, cur.children[c - 'a'], index + 1);
        }


    }
}

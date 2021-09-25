import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    //https://leetcode.com/problems/word-search-ii/ 212
    class Trie {
        Trie[] children;
        String word;

        public Trie() {
            children = new Trie[26];
            word = null;
        }
    }


    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0) return res;

        Trie root = new Trie();
        buildTrie(root, words);


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (root.children[c - 'a'] != null) {
                    dfs(board, i, j, root, res);
                }
            }
        }

        return res;

    }

    private void dfs(char[][] board, int i, int j, Trie cur, List<String> res) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) return;
        if (board[i][j] == '#') return;

        char c = board[i][j];

        if (cur.children[c - 'a'] == null) return;
        cur = cur.children[c - 'a'];
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }

        board[i][j] = '#';
        dfs(board, i + 1, j, cur, res);
        dfs(board, i - 1, j, cur, res);
        dfs(board, i, j + 1, cur, res);
        dfs(board, i, j - 1, cur, res);
        board[i][j] = c;
    }


    private void buildTrie(Trie root, String[] words) {
        for (String s : words) {
            Trie cur = root;

            for (char c : s.toCharArray()) {
                int index = (int) (c - 'a');
                if (cur.children[index] == null) {
                    cur.children[index] = new Trie();
                }
                cur = cur.children[index];
            }

            cur.word = s;
        }
    }
}

public class BattleshipsinaBoard {
    public int countBattleships(char[][] board) {
        //https://leetcode.com/problems/battleships-in-a-board/ 419
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    dfs(board, i, j);
                    count++;
                }
            }
        }

        return count;

    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'X') {
            return;
        }
        board[i][j] = 'p';
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
    }
}

public class Minesweeper {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        //https://leetcode.com/problems/minesweeper/ 529
        int i = click[0];
        int j = click[1];
        int m = board.length;
        int n = board[0].length;

        if (board[i][j] == 'M' || board[i][j] == 'X') {
            board[i][j] = 'X';
            return board;
        }

        int num = 0;
        for (int[] d : dirs) {
            int row = d[0] + i;
            int col = d[1] + j;
            if (row >= 0 && row < m && col >= 0 && col < n && board[row][col] == 'M') {
                num++;
            }
        }

        if (num > 0) {
            board[i][j] = (char) (num + '0');
            return board;
        }

        board[i][j] = 'B';

        for (int[] d : dirs) {
            int row = d[0] + i;
            int col = d[1] + j;
            if (row >= 0 && row < m && col >= 0 && col < n && board[row][col] == 'E') {
                updateBoard(board, new int[]{row, col});
            }
        }

        return board;

    }
}

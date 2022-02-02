public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        //https://leetcode.com/problems/sudoku-solver/ 37
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (valid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int row, int col, char c) {
        int xrow = 3 * (row / 3);
        int xcol = 3 * (col / 3);
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;
            if (board[xrow + i / 3][xcol + i % 3] == c) return false;
        }
        return true;
    }
}

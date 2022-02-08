import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //https://leetcode.com/problems/n-queens/ 51
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        traverse(board, 0, 0, n);
        return ans;
    }

    private void traverse(char[][] board, int row, int col, int n) {
        if (col == board[0].length) {
            col = 0;
            row++;
        }
        if (n == 0) {
            ans.add(toString(board));
            return;
        }
        if (row == board.length) {
            return;
        }
        if (isValid(board, row, col)) {
            board[row][col] = 'Q';
            n--;
            traverse(board, row, col + 1, n);
            board[row][col] = '.';
            n++;
        }
        traverse(board, row, col + 1, n);
    }

    private List<String> toString(char[][] board) {
        List<String> l = new ArrayList<>();
        StringBuilder s;
        for (char[] c : board) {
            s = new StringBuilder();
            for (char cu : c) {
                s.append(cu);
            }
            l.add(s.toString());
        }
        return l;
    }

    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if (board[i][col] != '.')
                return false;
            if (board[row][i] != '.')
                return false;
        }

        int i = row, j = col;

        while (0 <= i && 0 <= j) {
            if (board[i][j] != '.')
                return false;
            i--;
            j--;

        }

        i = row;
        j = col;

        while (0 <= i && j < n) {
            if (board[i][j] != '.')
                return false;
            i--;
            j++;

        }

        i = row;
        j = col;

        while (i < n && j < n) {
            if (board[i][j] != '.')
                return false;
            i++;
            j++;

        }

        i = row;
        j = col;

        while (i < n && 0 <= j) {
            if (board[i][j] != '.')
                return false;
            i++;
            j--;

        }
        return true;
    }
}

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //https://leetcode.com/problems/valid-sudoku/ 36
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char cur = board[i][j];
                if (cur != '.') {
                    if (!seen.add(cur + " row " + i) || !seen.add(cur + " col " + j) || !seen.add(cur + " box " + i / 3 + "/" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

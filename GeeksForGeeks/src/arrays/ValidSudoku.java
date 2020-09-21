package arrays;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char board[][] = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board) ? true : false);
    }

    private static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length < 9)
            return false;

        //row wise
        for (int r = 0; r < 9; r++) {
            Set<Character> set = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                if (set.contains(board[r][c])) {
                    return false;
                }
                set.add(board[r][c]);
            }
        }

        //column wise
        for (int c = 0; c < 9; c++) {
            Set<Character> set = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                if (board[r][c] == '.') {
                    continue;
                }
                if (set.contains(board[r][c])) {
                    return false;
                }
                set.add(board[r][c]);
            }
        }

        //3*3
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                Set<Character> set = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int rn = r + i;
                        int cn = c + j;
                        if (board[rn][cn] == '.') {
                            continue;
                        }
                        if (set.contains(board[rn][cn])) {
                            return false;
                        }
                        set.add(board[rn][cn]);
                    }
                }
            }
        }
        return true;
    }
}

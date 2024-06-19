package TopInterview150.Chapter_4_Matrix.lc_01_36_Valid_Sudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> horizontal = new HashSet<>();
            Set<Character> vertical = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (horizontal.contains(board[i][j])) {
                    return false;
                }
                if (board[i][j] != '.') {
                    horizontal.add(board[i][j]);
                }
                if (vertical.contains(board[j][i])) {
                    return false;
                }
                if (board[j][i] != '.') {
                    vertical.add(board[j][i]);
                }
            }
        }
        for (int row = 0; row < 9; row += 3) {
            for (int column = 0; column < 9; column += 3) {
                Set<Character> box = new HashSet<>();
                for (int boxI = row; boxI < row + 3; boxI++) {
                    for (int boxJ = column; boxJ < column + 3; boxJ++) {
                        if (box.contains(board[boxI][boxJ])) {
                            return false;
                        }
                        if (board[boxI][boxJ] != '.') {
                            box.add(board[boxI][boxJ]);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(board));
    }
}

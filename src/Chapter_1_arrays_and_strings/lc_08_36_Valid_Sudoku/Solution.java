package Chapter_1_arrays_and_strings.lc_08_36_Valid_Sudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rowElements = new HashSet<>();
            HashSet<Character> columnElements = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char rowElement = board[i][j];
                char columnElement = board[j][i];
                if (rowElement != '.' && rowElements.contains(rowElement)) {
                    return false;
                }
                if (columnElement != '.' && columnElements.contains(columnElement)) {
                    return false;
                }
                rowElements.add(rowElement);
                columnElements.add(columnElement);
            }
        }
        for (int iStart = 0; iStart < 9; iStart += 3) {
            for (int jStart = 0; jStart < 9; jStart += 3) {
                Set<Character> square = new HashSet<>();
                for (int i = iStart; i < iStart + 3; i++) {
                    for (int j = jStart; j < jStart + 3; j++) {
                        if (board[i][j] == '.') {
                            continue;
                        }
                        char numericValue = board[i][j];
                        if (square.contains(numericValue)) {
                            return false;
                        }
                        square.add(numericValue);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }
}

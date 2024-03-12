package Chapter_10_backtracking.lc_09_51_N_Queens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<Integer> columns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            columns.add(-1);
        }
        List<List<Integer>> result = new ArrayList<>();
        placeQueens(0, columns, result, n);

        return translateResult(result, n);
    }

    private List<List<String>> translateResult(List<List<Integer>> result, int n) {
        List<List<String>> stringResult = new ArrayList<>();
        for (List<Integer> list : result) {
            List<String> stringLine = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Integer currentNumber = list.get(i);
                StringBuilder string = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (currentNumber == j) {
                        string.append("Q");
                    } else {
                        string.append(".");
                    }
                }
                stringLine.add(string.toString());
            }
            stringResult.add(stringLine);
        }
        return stringResult;
    }

    public void placeQueens(int row, List<Integer> columns, List<List<Integer>> result, int n) {
        if (row == n) {
            result.add(new ArrayList<>(columns));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (checkValid(columns, row, j)) {
                columns.set(row, j);
                placeQueens(row + 1, columns, result, n);
            }
        }
    }

    private boolean checkValid(List<Integer> columns, int row, int column) {
        for (int i = 0; i < row; i++) {
            Integer tempColumn = columns.get(i);
            if (tempColumn == column) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(column - tempColumn)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }
}

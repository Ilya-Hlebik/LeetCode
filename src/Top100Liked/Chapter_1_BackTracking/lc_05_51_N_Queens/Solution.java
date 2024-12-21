package Top100Liked.Chapter_1_BackTracking.lc_05_51_N_Queens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            columns.add(-1);
        }
        placeQueen(n, 0, columns, result);

        return convertResult(result);
    }

    private List<List<String>> convertResult(List<List<Integer>> result) {
        List<List<String>> finalResult = new ArrayList<>();
        for (List<Integer> integers : result) {
            List<String> current = new ArrayList<>();
            finalResult.add(current);
            for (int j = 0; j < integers.size(); j++) {
                StringBuilder builder = new StringBuilder();
                Integer quinPosition = integers.get(j);
                for (int k = 0; k < integers.size(); k++) {
                    if (quinPosition == k) {
                        builder.append("Q");
                    } else {
                        builder.append(".");
                    }
                }
                current.add(builder.toString());
            }
        }
        return finalResult;
    }

    private void placeQueen(int n, int row, List<Integer> columns, List<List<Integer>> result) {
        if (row == n) {
            result.add(new ArrayList<>(columns));
        } else {
            for (int i = 0; i < n; i++) {
                if (valid(columns, row, i)) {
                    columns.set(row, i);
                    placeQueen(n, row + 1, columns, result);
                }
            }
        }
    }

    private boolean valid(List<Integer> columns, int x2, int y2) {
        for (int x1 = 0; x1 < x2; x1++) {
            Integer y1 = columns.get(x1);
            if (y1 == y2) {
                return false;
            }
            if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(4);
    }
}

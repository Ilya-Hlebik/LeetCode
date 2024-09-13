package TopInterview150.Chapter_15_BackTracking.lc_05_52_N_Queens_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int totalNQueens(int n) {
        List<int[]> coordinates = new ArrayList<>();
        return dfs(coordinates, n, 0);
    }

    public int dfs(List<int[]> coordinates, int n, int level) {
        if (!canPlace(coordinates)) {
            return 0;
        }
        if (level == n) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            coordinates.add(new int[]{level, i});
            int count = dfs(coordinates, n, level + 1);
            result += count;
            coordinates.remove(coordinates.size() - 1);
        }
        return result;
    }

    private boolean canPlace(List<int[]> coordinates) {
        Set<Integer> positiveDiag = new HashSet<>();
        Set<Integer> negativeDiag = new HashSet<>();
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int[] coordinate : coordinates) {
            int x = coordinate[0];
            int y = coordinate[1];

            if (!rows.add(x) || !cols.add(y) || !positiveDiag.add(x + y) || !negativeDiag.add(x - y)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(4));
    }
}

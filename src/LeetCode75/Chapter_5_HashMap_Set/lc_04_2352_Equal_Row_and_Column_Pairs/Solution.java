package LeetCode75.Chapter_5_HashMap_Set.lc_04_2352_Equal_Row_and_Column_Pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> rows = new HashMap<>();
        Map<List<Integer>, Integer> columns = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> column = new ArrayList<>();
            for (int j = 0; j < grid.length; j++) {
                row.add(grid[i][j]);
                column.add(grid[j][i]);
            }
            rows.put(row, rows.getOrDefault(row, 0)+1);
            columns.put(column, columns.getOrDefault(column, 0)+1);
        }
        int count = 0;
        for (Map.Entry<List<Integer>, Integer> row : rows.entrySet()) {
            if (columns.containsKey(row.getKey())) {
                count+= row.getValue() * columns.get(row.getKey());
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
    }
}

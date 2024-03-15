package Chapter_11_graphs.lc_07_Walls_And_Gates;

import java.util.Arrays;

public class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }

    }

    private void dfs(int[][] grid, int i, int j, int current) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == -1 || grid[i][j] < current) {
            return;
        }
        grid[i][j] = current;
        dfs(grid, i - 1, j, current + 1);
        dfs(grid, i, j + 1, current + 1);
        dfs(grid, i + 1, j, current + 1);
        dfs(grid, i, j - 1, current + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        int[][] arr2 = {
                {0,-1},
                {2147483647,2147483647}
        };
        solution.islandsAndTreasure(arr);
        System.out.println(Arrays.deepToString(arr));
        solution.islandsAndTreasure(arr2);
        System.out.println(Arrays.deepToString(arr2));
    }
}

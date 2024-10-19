package TopInterview150.Chapter_23_Multidimensional_DP.lc_02_64_Minimum_Path_Sum;

public class Solution {
    public int minPathSum(int[][] grid) {
        return minPathSumHelper(grid, 0, 0, new Integer[grid.length + 1][grid[0].length + 1]);
    }

    public int minPathSumHelper(int[][] grid, int i, int j, Integer[][] memo) {
        if (i > grid.length - 1 || j > grid[0].length - 1) {
            return Integer.MAX_VALUE;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = grid[i][j] + Math.min(minPathSumHelper(grid, i + 1, j, memo), minPathSumHelper(grid, i, j + 1, memo));
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(array));
    }
}

package Top100Liked.Chapter_4_Dynamic_Programming.lc_04_64_Minimum_Path_Sum;

public class Solution2 {
    public int minPathSum(int[][] grid) {
        return dfs(grid, 0, 0, new Integer[grid.length][grid[0].length]);
    }

    private int dfs(int[][] grid, int i, int j, Integer[][] memo) {
        if (i == grid.length || j == grid[i].length) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return grid[i][j];
        }

        return memo[i][j] = grid[i][j] + Math.min(dfs(grid, i + 1, j, memo), dfs(grid, i, j + 1, memo));
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}

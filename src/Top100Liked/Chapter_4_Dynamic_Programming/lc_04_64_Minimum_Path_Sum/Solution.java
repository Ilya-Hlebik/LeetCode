package Top100Liked.Chapter_4_Dynamic_Programming.lc_04_64_Minimum_Path_Sum;

public class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i + 1 < grid.length && j + 1 < grid[0].length) {
                    grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
                } else if (i + 1 < grid.length) {
                    grid[i][j] += grid[i + 1][j];
                } else if (j + 1 < grid[0].length) {
                    grid[i][j] += grid[i][j + 1];
                }
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}

package TopInterview150.Chapter_23_Multidimensional_DP.lc_03_63_Unique_Paths_2;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return dfs(obstacleGrid, 0, 0, new Integer[obstacleGrid.length][obstacleGrid[0].length]);
    }

    public int dfs(int[][] obstacleGrid, int i, int j, Integer[][] memo) {
        if (i > obstacleGrid.length - 1 || j > obstacleGrid[0].length - 1 || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }
        return memo[i][j] = dfs(obstacleGrid, i + 1, j, memo) + dfs(obstacleGrid, i, j + 1, memo);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {
                {0, 1},
                {0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(array));
    }
}

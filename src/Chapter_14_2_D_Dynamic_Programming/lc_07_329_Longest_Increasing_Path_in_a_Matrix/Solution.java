package Chapter_14_2_D_Dynamic_Programming.lc_07_329_Longest_Increasing_Path_in_a_Matrix;

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int longest = 0;
        int[][] memo = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                longest = Math.max(longest, dfs(matrix, i, j, matrix[i][j] - 1, memo));
            }
        }
        return longest;
    }

    private int dfs(int[][] matrix, int i, int j, int current, int[][] memo) {
        if (i < 0 || j < 0 || i > matrix.length - 1 || j > matrix[0].length - 1 || matrix[i][j] == -1 || matrix[i][j] <= current) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int temp = matrix[i][j];
        matrix[i][j] = -1;
        memo[i][j] = 1;
        memo[i][j] += Math.max(Math.max(dfs(matrix, i - 1, j, temp, memo), dfs(matrix, i, j + 1, temp, memo)),
                Math.max(dfs(matrix, i + 1, j, temp, memo), dfs(matrix, i, j - 1, temp, memo)));

        matrix[i][j] = temp;
        return memo[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        System.out.println(solution.longestIncreasingPath(array));
    }
}

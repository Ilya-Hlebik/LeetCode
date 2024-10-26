package TopInterview150.Chapter_23_Multidimensional_DP.lc_09_221_Maximal_Square;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        Integer[][] memo = new Integer[matrix.length+1][matrix[0].length+1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    res = Math.max(res, dfs(matrix, i, j, memo));
                }
            }
        }
        return res * res;
    }

    int dfs(char[][] matrix, int i, int j, Integer[][] memo) {
        if (i < 0 || j < 0 || i > matrix.length - 1 || j > matrix[0].length - 1 || matrix[i][j] == '0') {
            return 0;
        }
        if (memo[i][j] !=null){
            return memo[i][j];
        }
        return memo[i][j] = 1 + Math.min(Math.min(dfs(matrix, i + 1, j, memo), dfs(matrix, i + 1, j + 1, memo)), dfs(matrix, i, j + 1, memo));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] array = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(solution.maximalSquare(array));
    }
}

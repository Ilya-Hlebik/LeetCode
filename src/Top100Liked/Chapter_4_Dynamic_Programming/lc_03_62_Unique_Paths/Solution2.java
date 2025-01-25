package Top100Liked.Chapter_4_Dynamic_Programming.lc_03_62_Unique_Paths;

public class Solution2 {
    public int uniquePaths(int m, int n) {
        return dfs(m, n, 0, 0, new Integer[m][n]);
    }

    public int dfs(int m, int n, int i, int j, Integer[][] memo) {
        if (i == m || j == n) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        return memo[i][j] = dfs(m, n, i + 1, j, memo) + dfs(m, n, i, j + 1, memo);
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.uniquePaths(3, 7));
    }
}

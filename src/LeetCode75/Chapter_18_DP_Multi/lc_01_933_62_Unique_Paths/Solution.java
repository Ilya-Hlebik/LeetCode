package LeetCode75.Chapter_18_DP_Multi.lc_01_933_62_Unique_Paths;

public class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(m,n, 0,0, new boolean[m][n], new int[m][n]);
    }

    public int dfs(int m, int n, int x, int y, boolean[][] visited, int memo[][]) {
        if (x < 0 || y < 0 || x > m - 1 || y > n - 1 || visited[x][y]) {
            return 0;
        }
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (memo[x][y]!=0){
            return memo[x][y];
        }
        visited[x][y] = true;
        int count = dfs(m, n, x, y + 1, visited, memo)
                + dfs(m, n, x + 1, y, visited, memo);
        visited[x][y] = false;
        return memo[x][y] = count;
    }
}

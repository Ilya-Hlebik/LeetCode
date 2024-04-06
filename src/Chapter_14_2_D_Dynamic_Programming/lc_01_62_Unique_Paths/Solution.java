package Chapter_14_2_D_Dynamic_Programming.lc_01_62_Unique_Paths;

public class Solution {
    public int uniquePaths(int m, int n) {
        if (dfs(m, n, 0, 0, new Boolean[m + 1][n + 1])) {
            count++;
        }
        return count;
    }

    int count = 0;

    public boolean dfs(int m, int n, int x, int y, Boolean[][] memo) {
        if (x > m - 1 || y > n - 1 || (memo[x][y] != null && !memo[x][y])) {
            memo[x][y] = false;
            return false;
        }
        if ((x == m - 1 && y == n - 1) || (memo[x][y] != null && memo[x][y])) {
            memo[x][y] = true;
            return true;
        }
        if (dfs(m, n, x + 1, y, memo) || dfs(m, n, x, y + 1, memo)) {
            count++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(2, 2));
    }
}

package Top100Liked.Chapter_4_Dynamic_Programming.lc_05_70_Climbing_Stairs;

public class Solution {
    public int climbStairs(int n) {
        return dfs(n, new Integer[n+1]);
    }

    public int dfs(int n, Integer[] memo) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        return memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(44));
    }
}

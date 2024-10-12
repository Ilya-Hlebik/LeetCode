package TopInterview150.Chapter_22_1D_DP.lc_01_70_Climbing_Stairs;

public class Solution {
    public int climbStairs(int n) {
       return helper(n, new Integer[n+1]);
    }

    public int helper(int n, Integer[] memo) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (memo[n] != null) {
            return memo[n];
        }

        return memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(44));
    }
}

package freeRun.lc_65_279_Perfect_Squares;

public class Solution {
    public int numSquares(int n) {
        return solve(n, new Integer[n + 1]);
    }

    int solve(int n, Integer[] memo) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[n]!=null){
            return memo[n];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            res = Math.min(res, solve(n - (i * i), memo) + 1);
        }
        return memo[n]= res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }
}

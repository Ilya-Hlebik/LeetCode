package LeetCode75.Chapter_17_DP_1D.lc_01_1137_N_th_Tribonacci_Number;

public class Solution {
    public int tribonacci(int n) {
        return dfs(n, new int[n + 1]);
    }

    int dfs(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }
}

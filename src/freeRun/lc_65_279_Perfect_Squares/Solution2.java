package freeRun.lc_65_279_Perfect_Squares;

import java.util.Arrays;

public class Solution2 {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                 memo[i] = Math.min(memo[i], 1+ memo[i-(j*j)]);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.numSquares(12));
    }
}

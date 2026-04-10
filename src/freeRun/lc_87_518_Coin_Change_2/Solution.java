package freeRun.lc_87_518_Coin_Change_2;

public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1]; //dp[0] - count of combinations for current amount.
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
    }
}

package Chapter_13_1_D_Dynamic_Programming.lc_08_322_Coin_Change;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins.length == 0) {
            return 0;
        }
        int dp[] = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount+1;
        }
        dp[0] = 0;

        for (int a = 0; a <= amount; a++) {
            for (int coin : coins) {
                if (a - coin >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - coin]);
                }
            }
        }
        return dp[amount] < amount? dp[amount] : -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{1 }, 0));
    }
}

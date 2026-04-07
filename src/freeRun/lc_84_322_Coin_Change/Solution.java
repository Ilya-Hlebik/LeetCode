package freeRun.lc_84_322_Coin_Change;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int dfs = dfs(coins, amount, new Integer[amount + 1]);
        return dfs == Integer.MAX_VALUE? -1:dfs;
    }

    private int dfs(int[] coins, int amount, Integer[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[amount] != null) {
            return memo[amount];
        }
        int minNumber = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res =  dfs(coins, amount-coins[i], memo);
            if (res != Integer.MAX_VALUE) {
                minNumber = Math.min(minNumber, 1 +res);
            }
        }
        return memo[amount] = minNumber;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{2}, 3));
    }
}

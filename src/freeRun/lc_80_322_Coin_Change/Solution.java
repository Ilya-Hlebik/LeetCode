package freeRun.lc_80_322_Coin_Change;

public class Solution {
    public int coinChange(int[] coins, int amount) {

        int dfs = dfs(coins, amount, 0, new Integer[amount + 1][coins.length + 1]);
        return dfs == Integer.MAX_VALUE?-1:dfs;
    }

    private int dfs(int[] coins, int amount, int index, Integer[][] memo) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount][index] != null) {
            return memo[amount][index];
        }
        int result = Integer.MAX_VALUE;
        for (int i = index; i < coins.length; i++) {
            int dfs = 1 + dfs(coins, amount - coins[i], i, memo);
            if (dfs > 0) {
                result = Math.min(result, dfs);
            }
        }
        return memo[amount][index] = result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{357, 239, 73, 52}, 9832));
    }
}

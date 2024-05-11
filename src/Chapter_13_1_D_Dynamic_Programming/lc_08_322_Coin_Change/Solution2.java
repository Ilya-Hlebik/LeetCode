package Chapter_13_1_D_Dynamic_Programming.lc_08_322_Coin_Change;

public class Solution2 {
    public int coinChange(int coins[], int amount) {

        Integer[] memo = new Integer[amount + 1];
        int result = dfs(coins, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(int coins[], int amount, Integer[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[amount] != null) {
            return memo[amount];
        }
        int minAmount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int ans = dfs(coins, amount - coin, memo);
            if (ans != Integer.MAX_VALUE) {
                minAmount = Math.min(minAmount, ans + 1);
            }
        }
        return memo[amount] = minAmount;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.coinChange(new int[]{1, 2, 5}, 11));
    }
}

package Chapter_13_1_D_Dynamic_Programming.lc_08_322_Coin_Change;

public class Solution4 {
    public int coinChange(int[] coins, int amount) {
        int result = coinChangeHelper(coins, amount, new Integer[amount+1]);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int coinChangeHelper(int[] coins, int amount, Integer[] memo) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount]!= null){
            return memo[amount];
        }

        int ways = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeHelper(coins, amount - coin, memo);
            if (res != Integer.MAX_VALUE) {
                ways = Math.min(ways, res +1);
            }
        }
        return memo[amount] = ways;
    }
}

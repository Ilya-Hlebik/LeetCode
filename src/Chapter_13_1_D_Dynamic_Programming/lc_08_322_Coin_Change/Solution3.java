package Chapter_13_1_D_Dynamic_Programming.lc_08_322_Coin_Change;

public class Solution3 {
    public int coinChange(int[] coins, int amount) {
        return coinChangeHelper(coins, amount, 0, new int[amount+1]);
    }

    public int coinChangeHelper(int[] coins, int amount, int count, int[] memo) {
        if (amount < 0) {
            return 0;
        }
        if (memo[amount]!=0){
            return memo[amount];
        }
        if (amount == 0) {
            return count;
        }
        int ways = Integer.MAX_VALUE;
        for (int coin : coins) {
            int change = coinChangeHelper(coins, amount - coin, count + 1, memo);
            if (change != 0) {
                ways = Math.min(ways, change);
            }
        }
        memo[amount] = ways;
        return ways;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.coinChange(new int[]{1, 2,  5   }, 11));
    }
}

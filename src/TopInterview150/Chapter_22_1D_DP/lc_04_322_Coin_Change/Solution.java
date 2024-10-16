package TopInterview150.Chapter_22_1D_DP.lc_04_322_Coin_Change;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = coinChangeHelper(coins, amount, new Integer[amount + 1]);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int coinChangeHelper(int[] coins, int amount, Integer[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[amount] != null) {
            return memo[amount];
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int temp = coinChangeHelper(coins, amount - coin, memo);
            if (temp != Integer.MAX_VALUE) {
                result = Math.min(result, temp + 1);
            }
        }
        return memo[amount] = result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{357, 239, 73, 52}, 9832));
    }
}

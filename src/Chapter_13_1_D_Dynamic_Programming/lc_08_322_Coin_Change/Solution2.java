package Chapter_13_1_D_Dynamic_Programming.lc_08_322_Coin_Change;

import java.util.Arrays;

public class Solution2 {
    public int coinChange(int coins[], int amount) {
        int[] memo = new int[amount + 1]; // Adjusted size of the memoization array
        Arrays.fill(memo, -1);
        int result = dfs(coins, amount, 0, 0, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(int coins[], int amount, int currentAmount, int count, int[] memo) {
        if (currentAmount == amount) {
            return count;
        }
        if (currentAmount > amount) {
            return Integer.MAX_VALUE;
        }
        if (memo[currentAmount] != -1) {
            return memo[currentAmount];
        }
        int minAmount = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int result = dfs(coins, amount, currentAmount + coins[i], count + 1, memo);
            if (result != Integer.MAX_VALUE) {
                minAmount = Math.min(minAmount, result);
            }
        }
        if (minAmount != Integer.MAX_VALUE) {
            memo[currentAmount] = minAmount;
        }
        return   minAmount;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.coinChange(new int[]{1, 2, 5}, 11));
    }
}

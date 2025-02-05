package Top100Liked.Chapter_4_Dynamic_Programming.lc_13_322_Coin_Change;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int dfs = dfs(coins, amount, new Integer[amount + 1]);
        return dfs == Integer.MAX_VALUE ? -1 : dfs;
    }

    private int dfs(int[] coins, int amount, Integer[] memo) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != null) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int dfs = dfs(coins, amount - coin, memo);
            if (dfs != Integer.MAX_VALUE) {
                res = Math.min(res, 1 + dfs);
            }
        }
        return memo[amount] = res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 100));
    }
}

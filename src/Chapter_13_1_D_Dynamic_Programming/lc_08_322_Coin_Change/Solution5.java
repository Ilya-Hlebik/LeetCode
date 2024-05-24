package Chapter_13_1_D_Dynamic_Programming.lc_08_322_Coin_Change;

public class Solution5 {
    private int minCoins;

    public int coinChange(int[] coins, int[] limits, int amount) {
        minCoins = Integer.MAX_VALUE;
        dfs(coins, limits, amount, 0, 0);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private void dfs(int[] coins, int[] limits, int amount, int currentCoins, int index) {
        if (amount == 0) {
            minCoins = Math.min(minCoins, currentCoins);
            return;
        }

        if (index == coins.length) {
            return;
        }

        for (int i = 0; i <= limits[index] && i * coins[index] <= amount; i++) {
            dfs(coins, limits, amount - i * coins[index], currentCoins + i, index + 1);
        }
    }

    public static void main(String[] args) {
        Solution5 cc = new Solution5();
        int[] coins = {1, 2, 5};
        int[] limits = {5, 2, 1 }; // Limited coins: 5x1, 2x2, 2x5
        int amount = 11;
        System.out.println(cc.coinChange(coins, limits, amount)); // Output: 4 (5+5+1 or 5+2+2+2)
    }
}

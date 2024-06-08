package TopInterview150.Chapter_1_Array_String.lc_08_122_Best_Time_to_Buy_and_Sell_Stock_2;

public class Solution {
    public int maxProfit(int[] prices) {
        return dfs(prices, false, 0, new Integer[prices.length][2]);
    }

    private int dfs(int[] prices, boolean canSell, int index, Integer[][] memo) {
        if (index > prices.length - 1) {
            return 0;
        }
        if (memo[index][canSell ? 1 : 0] != null) {
            return memo[index][canSell ? 1 : 0];
        }
        int max = 0;
        if (canSell) {
            max = Math.max(Math.max(max, prices[index] + dfs(prices, false, index + 1, memo)), dfs(prices, true, index + 1, memo));
        } else {
            max = Math.max(dfs(prices, true, index + 1, memo) - prices[index], dfs(prices, false, index + 1, memo));
        }
        return memo[index][canSell ? 1 : 0] = max;
    }
}

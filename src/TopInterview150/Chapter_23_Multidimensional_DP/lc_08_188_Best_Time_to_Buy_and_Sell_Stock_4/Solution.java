package TopInterview150.Chapter_23_Multidimensional_DP.lc_08_188_Best_Time_to_Buy_and_Sell_Stock_4;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        return dfs(k, prices, 0, true, new Integer[prices.length+1][2][k+1]);
    }

    public int dfs(int limit, int[] prices, int index, boolean canBuy, Integer[][][] memo) {
        if (index > prices.length - 1 || limit == 0) {
            return 0;
        }
        if (memo[index][canBuy ? 1 : 0][limit] != null) {
            return memo[index][canBuy ? 1 : 0][limit];
        }
        int max = 0;
        if (canBuy) {
            max = Math.max(dfs(limit, prices, index + 1, canBuy, memo),
                    -prices[index] + dfs(limit, prices, index + 1, false, memo));
        } else {
            max = Math.max(dfs(limit, prices, index + 1, canBuy, memo),
                    prices[index] + dfs(limit-1, prices, index + 1, true, memo));
        }
        return memo[index][canBuy ? 1 : 0][limit] = max;
    }
}

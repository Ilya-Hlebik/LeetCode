package TopInterview150.Chapter_23_Multidimensional_DP.lc_07_123_Best_Time_to_Buy_and_Sell_Stock_3;

public class Solution {
    public int maxProfit(int[] prices) {
        return dfs(prices, 0, true, 2, new Integer[prices.length + 1][2][3]);
    }

    private int dfs(int[] prices, int index, boolean canBuy, int limit, Integer[][][] dp) {
        if (index > prices.length - 1 || limit == 0) {
            return 0;
        }
        if (dp[index][canBuy ? 1 : 0][limit] != null) {
            return dp[index][canBuy ? 1 : 0][limit];
        }
        int max = 0;
        if (canBuy) {
            max = Math.max(Math.max(max, dfs(prices, index + 1, true, limit, dp)),
                    -prices[index] + dfs(prices, index + 1, false, limit, dp));
        } else {
            max = Math.max(prices[index] + dfs(prices, index + 1, true, limit - 1, dp),
                    dfs(prices, index + 1, false, limit, dp));
        }
        return dp[index][canBuy ? 1 : 0][limit] = max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 1, 3, 1, 2}));
    }
}

package TopInterview150.Chapter_1_Array_String.lc_07_121_Best_Time_to_Buy_and_Sell_Stock;

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
            max = Math.max(Math.max(max, prices[index]), dfs(prices, true, index + 1, memo));
        } else {
            max = Math.max(dfs(prices, true, index + 1, memo) - prices[index], dfs(prices, false, index + 1, memo));
        }
        return memo[index][canSell ? 1 : 0] = max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{2, 1, 4}));
    }
}

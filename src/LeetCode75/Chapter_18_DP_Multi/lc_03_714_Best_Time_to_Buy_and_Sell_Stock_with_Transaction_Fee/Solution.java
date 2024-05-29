package LeetCode75.Chapter_18_DP_Multi.lc_03_714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int maxProfit(int[] prices, int fee) {
        return dfs(prices, fee, 0, 0);
    }

    int dfs(int[] prices, int fee, int index, int amount) {
        if (index > prices.length - 1) {
            return 0;
        }
        String key = index + "_" + amount;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int returnValue = 0;
        if (amount > 0) {
            if (prices[index] - fee - amount > 0) {
                returnValue = Math.max(dfs(prices, fee, index + 1, amount),
                        prices[index] - amount - fee + dfs(prices, fee, index + 1, 0));
            } else {
                returnValue = dfs(prices, fee, index + 1, amount);
            }
        } else {
            returnValue =  Math.max(dfs(prices, fee, index + 1, 0),
                    dfs(prices, fee, index + 1, prices[index]));
        }
        map.put(key, returnValue);
        return returnValue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }
}

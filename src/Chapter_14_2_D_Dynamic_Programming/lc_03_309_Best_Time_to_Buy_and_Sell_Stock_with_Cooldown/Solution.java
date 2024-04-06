package Chapter_14_2_D_Dynamic_Programming.lc_03_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> map = new HashMap<>();
        return dfs(prices, 0, true, map);
    }

    public int dfs(int[] prices, int index, boolean buying, Map<String, Integer> map) {
        if (index > prices.length - 1) {
            return 0;
        }
        String key = index + "_" + buying;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int coll = dfs(prices, index + 1, buying, map);
        int buyOrSell;
        if (buying) {
            buyOrSell = dfs(prices, index + 1, false, map) - prices[index];
        } else {
            buyOrSell = dfs(prices, index + 2, true, map) + prices[index];
        }
        int returnValue = Math.max(coll, buyOrSell);
        map.put(key, returnValue);
        return returnValue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 4}));
    }
}

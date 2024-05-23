package Chapter_14_2_D_Dynamic_Programming.lc_04_518_Coin_Change_2;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {
    public int change(int amount, int[] coins) {
        return changeHelper(amount, coins, 0, new HashMap<>());
    }

    public int changeHelper(int amount, int[] coins, int index, Map<String, Integer> memo) {
        if (amount == 0) {
            return 1;
        } else if (amount < 0 || index > coins.length - 1) {
            return 0;
        }
        String key = amount + "#"  + index;
        if (memo.containsKey(key)){
            return memo.get(key);
        }
        int coin = coins[index];
        int count = 0;
        for (int i = 0; i <= amount; i += coin) {
            count += changeHelper(amount - i, coins, index + 1, memo);
        }
        memo.put(key, count);
        return   count;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.change(5, new int[]{1, 2, 5}));
    }
}

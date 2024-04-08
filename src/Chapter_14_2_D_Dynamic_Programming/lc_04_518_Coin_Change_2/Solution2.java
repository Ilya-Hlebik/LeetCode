package Chapter_14_2_D_Dynamic_Programming.lc_04_518_Coin_Change_2;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.change(5, new int[]{1,2,5}));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (coin <= i) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }


}

package Chapter_14_2_D_Dynamic_Programming.lc_04_518_Coin_Change_2;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        return changeHelper(amount, coins, 0);
    }

    public int changeHelper(int amount, int[] coins, int index) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || index > coins.length - 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i <= amount; i += coins[index]) {
            res += changeHelper(amount - i, coins, index + 1);
        }
        return res;
    }
}

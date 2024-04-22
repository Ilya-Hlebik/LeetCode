package Chapter_3_sliding_window.lc_01_121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int minLeft = Integer.MAX_VALUE;
        int total = 0;
        for (int i = 0; i < prices.length; i++) {
            minLeft = Math.min(minLeft, prices[i]);
            int maxRight = Integer.MIN_VALUE;
            for (int j = i + 1; j < prices.length; j++) {
                maxRight = Math.max(maxRight, prices[j]);
                total = Math.max(maxRight - minLeft, total);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(solution.maxProfit(new int[]{1, 4, 2}));
        System.out.println(solution.maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
    }
}

package Chapter_3_sliding_window.lc_01_121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int total = 0;
        while (j < prices.length) {
            if (prices[j] > prices[i]){
                total = Math.max(prices[j] - prices[i], total);
            } else {
                i = j;
            }
            j++;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(solution.maxProfit(new int[]{1, 4, 2}));
        System.out.println(solution.maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
    }
}

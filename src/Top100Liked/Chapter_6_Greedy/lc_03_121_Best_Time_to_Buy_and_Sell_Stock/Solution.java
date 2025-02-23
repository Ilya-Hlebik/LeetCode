package Top100Liked.Chapter_6_Greedy.lc_03_121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int max = 0;
        while (r++ < prices.length) {
            if (prices[l] < prices[r]) {
                max = Math.max(max, prices[r] - prices[l]);
            } else {
                l=r;
            }
            r++;
        }
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}

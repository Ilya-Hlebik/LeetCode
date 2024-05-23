package LeetCode75.Chapter_17_DP_1D.lc_02_746_Min_Cost_Climbing_Stairs;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        memo[0] = cost[0];
        memo[1] = cost[1];
        for (int i = 2; i <cost.length; i++) {
            memo[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(memo[memo.length-1], memo[memo.length-2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}

package LeetCode75.Chapter_17_DP_1D.lc_02_746_Min_Cost_Climbing_Stairs;

public class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(cost, 0, new int[cost.length]), dfs(cost, 1, new int[cost.length]));
    }

    int dfs(int[] cost, int index, int[] memo) {
        if (index >= cost.length) {
            return 0;
        }
        if (memo[index] != 0) {
            return memo[index];
        }
        return memo[index] = cost[index] + Math.min(dfs(cost, index + 1, memo), dfs(cost, index + 2, memo));
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}

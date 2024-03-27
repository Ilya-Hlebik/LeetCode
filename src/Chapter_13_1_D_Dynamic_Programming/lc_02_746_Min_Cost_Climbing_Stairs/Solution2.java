package Chapter_13_1_D_Dynamic_Programming.lc_02_746_Min_Cost_Climbing_Stairs;

public class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(helper(cost, 0, new int[cost.length]), helper(cost, 1, new int[cost.length]));
    }

    public int helper(int[] cost, int i, int memo[]) {
        if (i >= cost.length) {
            return 0;
        }
        if (memo[i] != 0) {
            return memo[i];
        }

        int one = helper(cost, i + 1, memo);
        int two = helper(cost, i + 2, memo);
        memo[i] = cost[i] + Math.min(one, two);
        return memo[i];
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        System.out.println(solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}

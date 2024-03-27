package Chapter_13_1_D_Dynamic_Programming.lc_02_746_Min_Cost_Climbing_Stairs;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 2; i >= 0; i--) {
            cost[i] += Math.min(cost[i + 1], i + 2 > cost.length - 1 ? 0 : cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}

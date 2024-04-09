package Chapter_14_2_D_Dynamic_Programming.lc_05_494_Target_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, target, 0);
    }

    Map<String, Integer> memo = new HashMap<>();

    public int dfs(int[] nums, int current, int target, int index) {
        if (index == nums.length) {
            if (current == target) {
                return 1;
            }
            return 0;
        }
        String key = index + "_" + current;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int ways = dfs(nums, current - nums[index], target, index + 1)
                + dfs(nums, current + nums[index], target, index + 1);
        memo.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}

package LeetCode75.Chapter_17_DP_1D.lc_03_198_House_Robber;

public class Solution {
    public int rob(int[] nums) {
        return dfs(nums, 0, false, new Integer[nums.length][2]);
    }

    int dfs(int[] nums, int index, boolean skip, Integer[][] memo) {
        if (index > nums.length - 1) {
            return 0;
        }
        if (memo[index][skip ? 1 : 0] != null) {
            return memo[index][skip ? 1 : 0];
        }
        int current;
        if (skip) {
            current = dfs(nums, index + 1, false, memo);
        } else {
            current = Math.max(dfs(nums, index + 1, false, memo), nums[index] + dfs(nums, index + 1, true, memo));
        }
        return memo[index][skip ? 1 : 0] = current;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
    }
}

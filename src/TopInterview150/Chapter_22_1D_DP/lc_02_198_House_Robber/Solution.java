package TopInterview150.Chapter_22_1D_DP.lc_02_198_House_Robber;

public class Solution {
    public int rob(int[] nums) {
        return robHelper(nums, 0, new Integer[nums.length + 1]);
    }

    public int robHelper(int[] nums, int index, Integer[] memo) {
        if (index > nums.length - 1) {
            return 0;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        return memo[index] = Math.max(nums[index] + robHelper(nums, index + 2, memo), robHelper(nums, index + 1, memo));
    }
}

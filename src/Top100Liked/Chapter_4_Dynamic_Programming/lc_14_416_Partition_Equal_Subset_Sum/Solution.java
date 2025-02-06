package Top100Liked.Chapter_4_Dynamic_Programming.lc_14_416_Partition_Equal_Subset_Sum;

import java.util.Arrays;

public class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 != 0) {
            return false;
        }
        return dfs(nums, 0, totalSum / 2, new Boolean[1 + (totalSum / 2)][nums.length]);
    }

    private boolean dfs(int[] nums, int pos, int sum, Boolean[][] memo) {
        if (pos > nums.length - 1 || sum < 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        if (memo[sum][pos] != null) {
            return memo[sum][pos];
        }

        return memo[sum][pos] = dfs(nums, pos + 1, sum - nums[pos], memo) || dfs(nums, pos + 1, sum, memo);
    }
}

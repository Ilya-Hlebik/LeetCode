package Chapter_13_1_D_Dynamic_Programming.lc_12_416_Partition_Equal_Subset_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        return dfs(nums, totalSum, totalSum / 2, new boolean[nums.length], new HashMap<>());
    }

    private boolean dfs(int[] nums, int totalSum, int targetSum, boolean[] booleans, Map<String, Boolean> memo) {
        if (totalSum == targetSum) {
            return true;
        }
        if (targetSum > totalSum) {
            return false;
        }
        String key = Arrays.toString(booleans);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!booleans[i]) {
                booleans[i] = true;
                if (dfs(nums, totalSum - nums[i], targetSum, booleans, memo)) {
                    memo.put(key, true);
                    return true;
                }
                booleans[i] = false;
            }
        }
        memo.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}));
    }
}

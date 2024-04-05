package Chapter_13_1_D_Dynamic_Programming.lc_12_416_Partition_Equal_Subset_Sum;

public class Solution2 {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        int targetSum = totalSum / 2;
        boolean dp[] = new boolean[targetSum];
        dp[0] = true;

        for (int no : nums) {
            for (int i = targetSum; i >= no; i--) {
                if (dp[i - no]) {
                    if (i == targetSum) {
                        return true;
                    }
                    dp[i] = true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.canPartition(new int[]{1,2,3,5,1}));
    }
}

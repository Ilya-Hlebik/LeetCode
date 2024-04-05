package Chapter_13_1_D_Dynamic_Programming.lc_12_416_Partition_Equal_Subset_Sum;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        int targetSum = totalSum / 2;

        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> tempSet = new HashSet<>();
            for (Integer integer : set) {
                if (integer + nums[i] == targetSum) {
                    return true;
                }
                tempSet.add(integer + nums[i]);
                tempSet.add(integer);
            }
            set = tempSet;
            if (tempSet.contains(targetSum)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5, 1}));
    }
}

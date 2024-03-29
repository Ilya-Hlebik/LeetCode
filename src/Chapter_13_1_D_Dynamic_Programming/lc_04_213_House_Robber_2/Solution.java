package Chapter_13_1_D_Dynamic_Programming.lc_04_213_House_Robber_2;

import java.util.Arrays;

public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robHelper(Arrays.copyOfRange(nums, 1, nums.length)), robHelper(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    public int robHelper(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        for (int num : nums) {
            int temp = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{200, 3, 140, 20, 10}));
    }
}

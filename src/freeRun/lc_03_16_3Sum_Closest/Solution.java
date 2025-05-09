package freeRun.lc_03_16_3Sum_Closest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0;
        int currentClosest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int currentSum = current + nums[l] + nums[r];
                if (Math.abs(currentSum - target) < Math.abs(currentClosest - target)) {
                    currentClosest = currentSum;
                }
                if (currentSum > target) {
                    r--;
                } else if (currentSum < target) {
                    l++;
                } else {
                    return currentSum;
                }
            }
        }
        return currentClosest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1, 0, 1, 2, -1, -4}, 0));
    }
}

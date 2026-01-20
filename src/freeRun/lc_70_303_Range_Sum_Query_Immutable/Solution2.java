package freeRun.lc_70_303_Range_Sum_Query_Immutable;

public class Solution2 {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
   static class NumArray {
        int[] nums;
        int [] prefixSum;
        public NumArray(int[] nums) {
            this.nums = nums;
            prefixSum = new int[nums.length+1];
            for (int i = 1; i <= nums.length; i++) {
                prefixSum[i] = prefixSum[i-1] + nums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            return prefixSum[right+1] - prefixSum[left];
        }
    }
}


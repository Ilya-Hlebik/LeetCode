package freeRun.lc_73_307_Range_Sum_Query_Mutable;

public class Solution {
   static class NumArray {
        int prefix[];
        int nums[];

        public NumArray(int[] nums) {
            this.nums = nums;
            this.prefix = new int[nums.length+1];
            for (int i = 1; i <= nums.length; i++) {
                prefix[i] = prefix[i - 1] + nums[i - 1];
            }
        }

        public void update(int index, int val) {
            prefix[index+1] = prefix[index]+val;
            nums[index] = val;
            for (int i = index+2; i < prefix.length; i++) {
                prefix[i] = prefix[i-1]+nums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            return prefix[right+1] - prefix[left];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        NumArray numArray = new NumArray(new int[]{5,8,13});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1,-1);
        numArray.update(2,3);
        numArray.update(0,5);
        System.out.println(numArray.sumRange(0, 2));


    }
}

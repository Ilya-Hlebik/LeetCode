package freeRun.lc_70_303_Range_Sum_Query_Immutable;

import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}

class NumArray {
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        return IntStream.range(left, right + 1)
                .map(i-> nums[i])
                .sum();
    }
}

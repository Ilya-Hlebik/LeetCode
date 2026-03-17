package freeRun.lc_81_324_Wiggle_Sort_2;

import java.util.Arrays;

public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int leftPart = (nums.length +1) / 2;
        int[] leftArray = Arrays.copyOfRange(nums, 0, leftPart);
        int[] rightArray = Arrays.copyOfRange(nums, leftPart, nums.length);
        for (int i = 0, s = leftArray.length - 1, b = rightArray.length - 1; i < nums.length; i++) {
            if (i % 2 == 0 && s>=0) {
                nums[i] = leftArray[s--];
            } else {
                nums[i] = rightArray[b--];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

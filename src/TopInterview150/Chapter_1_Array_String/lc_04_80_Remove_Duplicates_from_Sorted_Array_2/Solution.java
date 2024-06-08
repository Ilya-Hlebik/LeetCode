package TopInterview150.Chapter_1_Array_String.lc_04_80_Remove_Duplicates_from_Sorted_Array_2;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 2;
        for (int i = 3; i < nums.length; i++) {
            if (nums[i] != nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        solution.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}

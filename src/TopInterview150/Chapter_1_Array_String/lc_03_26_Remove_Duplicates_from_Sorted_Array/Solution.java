package TopInterview150.Chapter_1_Array_String.lc_03_26_Remove_Duplicates_from_Sorted_Array;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}

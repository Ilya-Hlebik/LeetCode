package Top100Liked.Chapter_15_Misc.lc_05_75_Sort_Colors;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int index = 0;
        index = sortArray(nums, index, 0, 0);
        index = sortArray(nums, index, index, 1);
        sortArray(nums, index, index, 2);
    }

    private int sortArray(int[] nums, int index, int begin, int comparable) {
        for (int i = begin; i < nums.length && index < nums.length; i++) {
            if (nums[i] == comparable) {
                if (i != index) {
                    int temp = nums[index];
                    nums[index++] = nums[i];
                    nums[i] = temp;
                    i--;
                } else {
                    index++;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

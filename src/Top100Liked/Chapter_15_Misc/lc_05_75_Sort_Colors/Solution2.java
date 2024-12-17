package Top100Liked.Chapter_15_Misc.lc_05_75_Sort_Colors;

import java.util.Arrays;

public class Solution2 {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0; i < r; ) {
            if (nums[i] == 0) {
                swap(nums, l++, i++);
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, r--);
            }
        }

    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {0, 1};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

package Top100Liked.Chapter_13_Two_Pointers.lc_04_283_Move_Zeroes;

import java.util.Arrays;

public class Solution2 {
    public void moveZeroes(int[] nums) {
        int l = 0;
        int r = 1;
        while (r < nums.length) {
            while (l < nums.length && nums[l] != 0) {
                l++;
            }
            while (r < nums.length && (nums[r] == 0 || l >= r)) {
                r++;
            }
            if (l == nums.length || r == nums.length) {
                return;
            }
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

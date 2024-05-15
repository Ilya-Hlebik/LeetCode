package LeetCode75.Chapter_2_Two_Pointers.lc_01_283_Move_Zeroes;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        solution.moveZeroes(nums);
        System.out.println();
    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            while (j < nums.length && (nums[j] == 0 || i > j)) {
                j++;
            }
            if (j == nums.length || i == nums.length) {
                return;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}

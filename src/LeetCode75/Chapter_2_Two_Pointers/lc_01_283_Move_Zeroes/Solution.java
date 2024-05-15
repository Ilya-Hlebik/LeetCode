package LeetCode75.Chapter_2_Two_Pointers.lc_01_283_Move_Zeroes;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0};
        solution.moveZeroes(nums);
        System.out.println();
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        while (true){
            boolean wasMoved = false;
            for (int i = 0; i < nums.length - 1 - j; i++) {
                if (nums[i] == 0) {
                    wasMoved= true;
                    int temp = nums[i + 1];
                    nums[i + 1] = 0;
                    nums[i] = temp;
                }
            }
            if (!wasMoved){
                break;
            }
            j++;
        }
    }
}

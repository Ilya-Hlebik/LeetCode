package Top100Liked.Chapter_15_Misc.lc_09_238_Product_of_Array_Except_Self;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}

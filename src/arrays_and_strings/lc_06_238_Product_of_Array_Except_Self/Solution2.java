package arrays_and_strings.lc_06_238_Product_of_Array_Except_Self;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] ints = solution.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int cur = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = cur;
            cur *= nums[i];
        }
        cur = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= cur;
            cur *= nums[i];
        }
        return result;
    }
}

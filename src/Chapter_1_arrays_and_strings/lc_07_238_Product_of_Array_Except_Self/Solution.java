package Chapter_1_arrays_and_strings.lc_07_238_Product_of_Array_Except_Self;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int res = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    res *= nums[j];
                }
            }
            result[i] = res;
        }
        return result;
    }
}

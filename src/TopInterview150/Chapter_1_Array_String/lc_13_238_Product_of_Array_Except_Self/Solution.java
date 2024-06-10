package TopInterview150.Chapter_1_Array_String.lc_13_238_Product_of_Array_Except_Self;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int current = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = current;
            current *= nums[i];
        }
        current = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= current;
            current *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.productExceptSelf(new int[]{1, 2, 3, 4});
    }
}

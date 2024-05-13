package LeetCode75.Chapter_1_Array_String.lc_07_238_Product_of_Array_Except_Self;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int cur = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = cur;
            cur *= nums[i];
        }
        cur = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = cur * result[i];
            cur *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.productExceptSelf(new int[]{1, 2, 3, 4});
    }
}

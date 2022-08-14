package arrays_and_strings;

/*Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.*/
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, left_product = 1, right_product = 1, n = nums.length;

        for (int i = 0; i < n; i++) {
            max = Math.max(left_product *= nums[i], max);
            if (nums[i] == 0) {
                left_product = 1;
            }
            max = Math.max(right_product *= nums[n - i - 1], max);
            if (nums[n - i - 1] == 0) {
                right_product = 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-2, 0, 1, 0, -1}));
    }
}

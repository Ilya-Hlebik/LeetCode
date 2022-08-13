package arrays_and_strings;

import java.util.Arrays;

/*Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1*/
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = x;
            if (i == len) {
                len++;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }
}

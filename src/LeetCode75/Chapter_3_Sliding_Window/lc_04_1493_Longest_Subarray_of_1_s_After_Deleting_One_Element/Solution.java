package LeetCode75.Chapter_3_Sliding_Window.lc_04_1493_Longest_Subarray_of_1_s_After_Deleting_One_Element;

public class Solution {
    public int longestSubarray(int[] nums) {
        int k = 1;
        int count = 0;
        int max = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] == 1) {
                count++;
            } else if (k > 0) {
                k--;
            } else {
                while (nums[l] != 0) {
                    l++;
                    count--;
                }
                l++;
            }
            max = Math.max(max, count);
            r++;
        }
        return max - k;
    }
}

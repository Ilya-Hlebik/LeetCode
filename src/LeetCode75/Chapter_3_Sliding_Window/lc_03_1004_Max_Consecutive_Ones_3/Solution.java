package LeetCode75.Chapter_3_Sliding_Window.lc_03_1004_Max_Consecutive_Ones_3;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int max = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                count++;
            } else if (k > 0) {
                k--;
                count++;
            } else {
                while (nums[l] != 0) {
                    l++;
                    count--;
                }
                l++;
            }
            max = Math.max(count, max);
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
}

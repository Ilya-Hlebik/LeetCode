package LeetCode75.Chapter_3_Sliding_Window.lc_01_643_Maximum_Average_Subarray1;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0;
        int r = 0;
        double sum = 0;
        double max = Integer.MIN_VALUE;
        while (r < k - 1) {
            sum += nums[r];
            r++;
        }
        while (r < nums.length) {
            sum += nums[r];
            max = Math.max(max, sum / k);
            sum -= nums[l];
            l++;
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}

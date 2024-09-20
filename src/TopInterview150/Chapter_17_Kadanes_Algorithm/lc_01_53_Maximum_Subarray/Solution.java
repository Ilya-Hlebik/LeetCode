package TopInterview150.Chapter_17_Kadanes_Algorithm.lc_01_53_Maximum_Subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int current = 0;
        for (int num : nums) {
            current += num;
            max = Math.max(current, max);
            current = Math.max(current, 0);
        }
        return max;
    }
}

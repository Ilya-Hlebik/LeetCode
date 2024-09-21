package TopInterview150.Chapter_17_Kadanes_Algorithm.lc_02_918_Maximum_Sum_Circular_Subarray;

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int currentMin = 0;
        int currentMax = 0;
        int sum = 0;
        for (int num : nums) {
            currentMin+=num;
            currentMax+=num;
            max = Math.max(currentMax, max);
            currentMax = Math.max(currentMax, 0);
            min = Math.min(currentMin, min);
            currentMin = Math.min(currentMin, 0);
            sum+=num;
        }
        if (max<0){
            return max;
        }
        return Math.max(max, sum - min);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubarraySumCircular(new int[]{5, -7,6,7, -7, 5}));
    }
}

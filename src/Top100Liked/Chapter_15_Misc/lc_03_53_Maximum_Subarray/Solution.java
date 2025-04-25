package Top100Liked.Chapter_15_Misc.lc_03_53_Maximum_Subarray;

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}

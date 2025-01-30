package Top100Liked.Chapter_4_Dynamic_Programming.lc_08_152_Maximum_Product_Subarray;

public class Solution {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            int temp = max;
            max = Math.max(Math.max(max * num, num), min * num);
            min = Math.min(Math.min(min * num, num), temp * num);
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new int[]{-2, 3, -4}));
    }
}

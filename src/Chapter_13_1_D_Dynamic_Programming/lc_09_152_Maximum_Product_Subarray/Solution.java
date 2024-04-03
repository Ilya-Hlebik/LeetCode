package Chapter_13_1_D_Dynamic_Programming.lc_09_152_Maximum_Product_Subarray;

public class Solution {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int currentMin = 1;
        int currentMax = 1;
        for (int num : nums) {
            int temp = currentMax * num;
            currentMax = Math.max(num, Math.max(temp, currentMin * num));
            currentMin = Math.min(num, Math.min(temp, currentMin * num));
            result = Math.max(currentMax, result);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new int[]{-2, 0, -1, -2}));
    }
}

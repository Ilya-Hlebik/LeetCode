package TopInterview150.Chapter_1_Array_String.lc_16_42_Trapping_Rain_Water;

public class Solution {
    public int trap(int[] height) {
        int total = 0;
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        int i = 0;
        int j = height.length - 1;
        while (j > i) {
            if (maxLeft> maxRight){
                j--;
                total += Math.max(0, maxRight - height[j]);
                maxRight = Math.max(maxRight, height[j]);
            }
            else {
                i++;
                total += Math.max(0, maxLeft - height[i]);
                maxLeft = Math.max(maxLeft, height[i]);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}

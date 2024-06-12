package TopInterview150.Chapter_2_Two_Pointers.lc_04_11_Container_With_Most_Water;

public class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[r], height[l]));
            if (height[r]> height[l]){
                l++;
            }
            else {
                r--;
            }
        }
        return maxArea;
    }
}

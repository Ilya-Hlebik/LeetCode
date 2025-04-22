package Top100Liked.Chapter_13_Two_Pointers.lc_03_42_Trapping_Rain_Water;

public class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int total = 0;
        int maxLeft = height[l];
        int maxRight = height[r];
        while (l < r) {
            if (maxRight < maxLeft){
                r--;
                total += Math.max(0, maxRight  - height[r]);
                maxRight = Math.max(maxRight, height[r]);
            }
            else {
                l++;
                total += Math.max(0, maxLeft  - height[l]);
                maxLeft = Math.max(maxLeft, height[l]);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}

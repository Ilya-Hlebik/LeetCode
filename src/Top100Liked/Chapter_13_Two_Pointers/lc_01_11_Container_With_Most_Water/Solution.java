package Top100Liked.Chapter_13_Two_Pointers.lc_01_11_Container_With_Most_Water;

public class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r && r < height.length) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1,1}));
    }
}

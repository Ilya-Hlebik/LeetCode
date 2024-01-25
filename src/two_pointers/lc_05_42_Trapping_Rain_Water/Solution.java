package two_pointers.lc_05_42_Trapping_Rain_Water;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int trap(int[] height) {
        int maxLeft = height[0];
        int total = 0;
        Map<Integer, Integer> maxRightMap = new HashMap<>();
        maxRightMap.put(height.length-1, 0);
        int maxRight = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i + 1]);
            maxRightMap.put(i, maxRight);
        }
        for (int i = 1; i < height.length; i++) {
            maxLeft = Math.max(maxLeft, height[i - 1]);
            total += Math.max(0, Math.min(maxLeft, maxRightMap.get(i)) - height[i]);
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}

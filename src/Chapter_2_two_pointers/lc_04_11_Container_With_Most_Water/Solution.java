package Chapter_2_two_pointers.lc_04_11_Container_With_Most_Water;

public class Solution {
    public int maxArea(int[] height) {
        int maxAmount = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        while (j > i) {
            maxAmount = Math.max(maxAmount, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxAmount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(solution.maxArea(new int[]{1, 2, 4, 3}));
        System.out.println(solution.maxArea(new int[]{1, 2, 3, 4, 5, 25, 24, 3, 4}));
    }
}

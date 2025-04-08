package Top100Liked.Chapter_12_Stack.lc_02_84_Largest_Rectangle_in_Histogram;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int index = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] pop = stack.pop();
                index = pop[0];
                int height = pop[1];
                max = Math.max(max, height * (i - index));
            }
            stack.push(new int[]{index, heights[i]});
        }
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            max = Math.max(max, pop[1] * (heights.length - pop[0]));
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}

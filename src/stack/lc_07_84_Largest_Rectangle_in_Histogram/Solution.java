package stack.lc_07_84_Largest_Rectangle_in_Histogram;

import java.util.Map;
import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int index = i;
            while (!stack.isEmpty() && stack.peek().getValue() > heights[i]) {
                Map.Entry<Integer, Integer> pop = stack.pop();
                index = pop.getKey();
                max = Math.max((i - index) * pop.getValue(), max);
            }
            stack.push(Map.entry(index, heights[i]));
        }
        while (!stack.isEmpty()) {
            Map.Entry<Integer, Integer> pop = stack.pop();
            max = Math.max(max, (heights.length - pop.getKey()) * pop.getValue());
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(solution.largestRectangleArea(new int[]{1, 2, 2}));
    }
}

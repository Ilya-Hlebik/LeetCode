package LeetCode75.Chapter_22_Monotonic_Stack.lc_01_739_Daily_Temperatures;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.dailyTemperatures(new int[]{30, 40, 50, 60});
    }
}

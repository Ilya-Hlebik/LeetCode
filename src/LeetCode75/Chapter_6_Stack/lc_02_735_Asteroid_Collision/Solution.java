package LeetCode75.Chapter_6_Stack.lc_02_735_Asteroid_Collision;

import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (stack.isEmpty()) {
                stack.push(asteroid);
            } else if ((stack.peek() >= 0 && asteroid >= 0) || (stack.peek() < 0 && asteroid < 0) || (stack.peek() < 0 && asteroid >= 0)) {
                stack.push(asteroid);
            } else if (Math.abs(stack.peek()) == Math.abs(asteroid) && stack.peek() >= 0) {
                stack.pop();
            } else if (Math.abs(stack.peek()) < Math.abs(asteroid) && stack.peek() >= 0) {
                stack.pop();
                i--;
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.asteroidCollision(new int[]{-2, -1, 1, 2});
    }

}

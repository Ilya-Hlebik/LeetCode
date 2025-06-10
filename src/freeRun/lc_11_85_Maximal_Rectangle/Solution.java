package freeRun.lc_11_85_Maximal_Rectangle;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[] current = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    current[j] = 0;
                } else {
                    current[j]++;
                }
            }
            max = Math.max(max, calculateMax(current));
        }
        return max;
    }

    private int calculateMax(int[] current) {
        Stack<int[]> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < current.length; i++) {
            int intVal = current[i];
            int index = i;
            while (!stack.isEmpty() && stack.peek()[1] > intVal) {
                int[] pop = stack.pop();
                index = pop[0];
                max = Math.max(max, pop[1] * (i - index));
            }
            stack.push(new int[]{index, intVal});
        }
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            max = Math.max(max, pop[1] * (current.length - pop[0]));
        }
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {
                {'1'},
        };

        System.out.println(solution.maximalRectangle(matrix));
    }
}

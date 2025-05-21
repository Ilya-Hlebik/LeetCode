package freeRun.lc_07_59_Spiral_Matrix_2;

import java.util.Arrays;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int counter = 1;
        for (int i = 0; i < n && counter<= Math.pow(n,2); i++) {
            for (int j = i; j < n - i; j++) {
                res[i][j] = counter++;
            }
            for (int j = i + 1; j < n - i; j++) {
                res[j][n - i - 1] = counter++;
            }
            for (int j = n - i - 2; j >= i; j--) {
                res[n - i - 1][j] = counter++;
            }

            for (int j = n - i -2; j > i; j--) {
                res[j][i] = counter++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
    }
}

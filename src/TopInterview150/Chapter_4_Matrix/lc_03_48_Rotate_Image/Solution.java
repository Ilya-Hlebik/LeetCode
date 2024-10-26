package TopInterview150.Chapter_4_Matrix.lc_03_48_Rotate_Image;

import java.util.Arrays;

public class Solution {
    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;
        while (l < r) {
            int top = l;
            int bottom = r;
            for (int i = 0; i < r - l; i++) {
                int topLeft = matrix[top][l + i];
                matrix[top][l + i] = matrix[bottom - i][l];
                matrix[bottom - i][l] = matrix[bottom][r - i];
                matrix[bottom][r - i] = matrix[top + i][r];
                matrix[top + i][r] = topLeft;
            }
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

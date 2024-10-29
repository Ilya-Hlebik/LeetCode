package TopInterview150.Chapter_4_Matrix.lc_02_54_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        while (left < right) {
            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top + 1; i < bottom; i++) {
                result.add(matrix[i][right - 1]);
            }

            if (!(left < right-1 && top + 1 < bottom)) {
                break;
            }
            for (int i = right - 2; i >= left; i--) {
                result.add(matrix[bottom - 1][i]);
            }

            for (int i = bottom - 2; i > top; i--) {
                result.add(matrix[i][left]);
            }
            bottom--;
            right--;
            left++;
            top++;

        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(solution.spiralOrder(matrix));
    }
}

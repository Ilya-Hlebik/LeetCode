package TopInterview150.Chapter_4_Matrix.lc_04_73_Set_Matrix_Zeroes;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> zeros = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < zeros.size(); i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[zeros.get(i)[0]][j] = 0;
            }
        }

        for (int i = 0; i < zeros.size(); i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][zeros.get(i)[1]] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.setZeroes(new int[][]{{0,1}});
    }
}

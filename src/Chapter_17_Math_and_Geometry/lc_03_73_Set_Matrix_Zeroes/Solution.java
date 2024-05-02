package Chapter_17_Math_and_Geometry.lc_03_73_Set_Matrix_Zeroes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public void setZeroes(int[][] matrix) {
        Set<Integer> zeroColumns = new HashSet<>();
        Set<Integer> zeroRows = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    zeroColumns.add(j);
                    zeroRows.add(i);
                }
            }
        }
        for (Integer zeroColumn : zeroColumns) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][zeroColumn] = 0;
            }
        }
        for (Integer zeroRow : zeroRows) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[zeroRow][i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

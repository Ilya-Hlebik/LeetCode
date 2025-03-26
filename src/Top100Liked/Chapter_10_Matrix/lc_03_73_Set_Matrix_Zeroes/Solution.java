package Top100Liked.Chapter_10_Matrix.lc_03_73_Set_Matrix_Zeroes;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (Integer row : rows) {
            for (int i = 0; i< matrix[0].length; i++){
                matrix[row][i] = 0;
            }
        }
        for (Integer column : columns) {
            for (int i = 0; i< matrix.length; i++){
                matrix[i][column] = 0;
            }
        }
    }
}

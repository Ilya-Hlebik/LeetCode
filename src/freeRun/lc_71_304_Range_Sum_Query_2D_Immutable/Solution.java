package freeRun.lc_71_304_Range_Sum_Query_2D_Immutable;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
/*        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };*/
        int[][] matrix = {{1}, {-7}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(1, 0, 1, 0));
    }

    static class NumMatrix {
        int[][] matrix;
        int[] prefixSum;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            prefixSum = new int[(matrix.length * matrix[0].length) + 1];
            for (int i = 0, k = 1; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++, k++) {
                    prefixSum[k] = prefixSum[k - 1] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                int left = (matrix[0].length * i) + col1;
                int right = (matrix[0].length * i) + col2;
                sum += prefixSum[right + 1] - prefixSum[left];
            }
            return sum;
        }
    }
}

package freeRun.lc_71_304_Range_Sum_Query_2D_Immutable;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
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
        int[][] prefixSum;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            prefixSum = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i <= matrix.length; i++) {
                for (int j = 1; j <= matrix[i-1].length; j++) {
                    prefixSum[i][j]
                            = prefixSum[i - 1][j]
                            + prefixSum[i][j - 1]
                            - prefixSum[i - 1][j - 1]
                            + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefixSum[row2+1][col2+1]
                    -prefixSum[row1][col2+1]
                    -prefixSum[row2+1][col1]
                    + prefixSum[row1][col1]
                    ;
        }
    }
}

package Chapter_5_binary_search.lc_02_74_Search_a_2D_Matrix;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int matrixRows = matrix.length;
        int matrixColumns = matrix[matrix.length - 1].length;
        int total = matrixColumns * matrixRows;
        return searchMatrix(matrix, target, 0, total - 1, matrixColumns);
    }

    public boolean searchMatrix(int[][] matrix, int target, int min, int max, int matrixColumns) {
        if (min > max) {
            return false;
        }
        int mid = min + (max - min) / 2;
        int midValue = matrix[getRow(mid, matrixColumns)][getColumn(mid, matrixColumns)];
        if (midValue == target) {
            return true;
        }
        if (midValue > target) {
            return searchMatrix(matrix, target, min, mid - 1, matrixColumns);
        }
        return searchMatrix(matrix, target, mid + 1, max, matrixColumns);
    }

    public int getRow(int number, int matrixColumns) {
        return number / matrixColumns;
    }

    public int getColumn(int number, int matrixColumns) {
        return number % matrixColumns;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }
}

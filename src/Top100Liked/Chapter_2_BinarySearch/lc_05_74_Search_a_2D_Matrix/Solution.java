package Top100Liked.Chapter_2_BinarySearch.lc_05_74_Search_a_2D_Matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = (matrix.length * matrix[0].length) - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = calculateMidValue(matrix, mid);
            if (midVal == target) {
                return true;
            }
            if (target > midVal) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    private int calculateMidValue(int[][] matrix, int mid) {
        int x = mid / matrix[0].length;
        int y = mid - (matrix[0].length * x);
        return matrix[x][y];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        solution.searchMatrix(array, 3);
    }
}

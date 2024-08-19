package TopInterview150.Chapter_18_Binary_Search.lc_02_74_Search_a_2D_Matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = (matrix.length * matrix[0].length) - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midValue = matrix[mid / matrix[0].length][(mid % matrix[0].length)];
            if (midValue == target) {
                return true;
            }
            if (midValue > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.searchMatrix(new int[][]{{1}, {2}, {3}, {4}}, 2);
    }
}

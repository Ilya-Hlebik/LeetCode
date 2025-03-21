package Top100Liked.Chapter_10_Matrix.lc_01_48_Rotate_Image;

public class Solution {
        public void rotate(int[][] matrix) {
            int l = 0;
            int r = matrix.length - 1;
            while (l < r) {
                int top = l;
                int bottom = r;
                for (int i = 0; i < r - l; i++) {
                    int topEl = matrix[top][i + l];
                    matrix[top][i + l] = matrix[bottom - i][l];
                    matrix[bottom - i][l] = matrix[bottom][r - i];
                    matrix[bottom][r - i] = matrix[top + i][r];
                    matrix[top + i][r] = topEl;
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
    }
}

package Chapter_17_Math_and_Geometry.lc_01_48_Rotate_Image;

public class Solution {
    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;
        while (l < r) {
            int top = l;
            int bottom = r;
            for (int i = 0; i <= r - l; i++) {

                int topLeft = matrix[top][l + i];

                matrix[top][l + i] = matrix[bottom - i][l];

                matrix[bottom - i][l] = matrix[bottom][r - i];

                matrix[bottom][r - i] = matrix[top + i][r];

                matrix[top + i][r] = topLeft;
            }
            r--;
            l++;
        }
    }
}

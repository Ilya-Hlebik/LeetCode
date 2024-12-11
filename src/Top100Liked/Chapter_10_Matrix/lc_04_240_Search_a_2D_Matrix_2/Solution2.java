package Top100Liked.Chapter_10_Matrix.lc_04_240_Search_a_2D_Matrix_2;

public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length - 1;
        while (y > 0 && x < matrix.length) {
            int midVal = matrix[x][y];
            if (midVal == target) {
                return true;
            } else if (midVal > target) {
                y--;
            }
            else {
                x++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(solution.searchMatrix(matrix, 5));
    }
}

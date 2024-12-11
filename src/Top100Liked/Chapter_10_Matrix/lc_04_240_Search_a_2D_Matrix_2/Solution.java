package Top100Liked.Chapter_10_Matrix.lc_04_240_Search_a_2D_Matrix_2;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = 0;
        while (x < matrix.length && y < matrix[0].length) {
            if (matrix[x][y] <= target && matrix[x][matrix[0].length - 1] >= target) {
                if (dfs(matrix, x, matrix[0].length - 1, target, x, y, true)) {
                    return true;
                }
            }
            if (matrix[x][y] <= target && matrix[matrix.length - 1][y] >= target) {
                if (dfs(matrix, y, matrix.length - 1, target, x, y, false)) {
                    return true;
                }
            }
            x++;
            y++;
        }
        return false;
    }

    public boolean dfs(int[][] matrix, int min, int max, int target, int x, int y, boolean horizontal) {
        if (min > max) {
            return false;
        }
        int mid = min + (max - min) / 2;
        int midVal = horizontal ? matrix[x][mid] : matrix[mid][y];
        if (midVal == target) {
            return true;
        } else if (midVal > target) {
            return dfs(matrix, min, mid - 1, target, x, y, horizontal);
        }
        return dfs(matrix, mid + 1, max, target, x, y, horizontal);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(solution.searchMatrix(matrix, 20));
    }
}

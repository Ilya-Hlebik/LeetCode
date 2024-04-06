package Chapter_14_2_D_Dynamic_Programming.lc_01_62_Unique_Paths;

public class Solution2 {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m + 1][n + 1];
        cache[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (cache[i][j] != 0) {
                    continue;
                }
                int bottom = cache[i + 1][j];
                int right = cache[i][j + 1];
                cache[i][j] = bottom + right;
            }
        }
        return cache[0][0];
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.uniquePaths(19, 13));
    }
}

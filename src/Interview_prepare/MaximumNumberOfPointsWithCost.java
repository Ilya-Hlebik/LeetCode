package Interview_prepare;

/*You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.

To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.

However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.

Return the maximum number of points you can achieve.

abs(x) is defined as:

x for x >= 0.
-x for x < 0.*/
public class MaximumNumberOfPointsWithCost {
    public long maxPoints2(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] pre = new long[n];
        for (int i = 0; i < n; ++i) {
            pre[i] = points[0][i];
        }
        for (int i = 0; i < m - 1; ++i) {
            long[] lft = new long[n];
            long[] rgt = new long[n];
            long[] cur = new long[n];
            lft[0] = pre[0];
            rgt[n - 1] = pre[n - 1];
            for (int j = 1; j < n; ++j) {
                lft[j] = Math.max(lft[j - 1] - 1, pre[j]);
            }
            for (int j = n - 2; j >= 0; --j) {
                rgt[j] = Math.max(rgt[j + 1] - 1, pre[j]);
            }

            for (int j = 0; j < n; ++j) {
                cur[j] = points[i + 1][j] + Math.max(lft[j], rgt[j]);
            }
            pre = cur;
        }
        long ans = 0;
        for (int i = 0; i < n; ++i)
            ans = Math.max(ans, pre[i]);
        return ans;
    }
    public long maxPoints(int[][] points) {
        long ans = 0;
        int n = points[0].length;
        long []dp = new long[n];
        for (int[] point : points) {
            for (int j = 0; j < n; j++) {
                dp[j] += point[j];
            }
            for (int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            }
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j + 1] - 1);
            }
        }
        for(int i=0;i<n;i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumNumberOfPointsWithCost maximumNumberOfPointsWithCost = new MaximumNumberOfPointsWithCost();
        System.out.println(maximumNumberOfPointsWithCost.maxPoints(new int[][]{{1, 2, 3}, {1, 5, 1}, {3, 1, 1}}));
    }
}

package TopInterview150.Chapter_21_Math.lc_06_149_Max_Points_on_a_Line;

public class Solution {
    public int maxPoints(int[][] points) {
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int currentMax = 2;
                for (int k = j + 1; k < points.length; k++) {
                    if (dx * (points[k][1] - points[i][1]) == dy * (points[k][0] - points[i][0])) {
                        currentMax++;
                    }
                }
                max = Math.max(currentMax, max);
            }
        }
        return max;
    }
}

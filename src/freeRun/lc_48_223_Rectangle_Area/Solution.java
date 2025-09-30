package freeRun.lc_48_223_Rectangle_Area;

public class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int w = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int h = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        int overlapS = w * h;
        int aS = (ay2 - ay1) * (ax2 - ax1);
        int bS = (by2 - by1) * (bx2 - bx1);
        return aS + bS - overlapS;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
    }
}

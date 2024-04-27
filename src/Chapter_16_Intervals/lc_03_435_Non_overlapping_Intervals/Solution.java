package Chapter_16_Intervals.lc_03_435_Non_overlapping_Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int res =0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]>=prevEnd){
                prevEnd = intervals[i][1];
            }
            else {
                res +=1;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

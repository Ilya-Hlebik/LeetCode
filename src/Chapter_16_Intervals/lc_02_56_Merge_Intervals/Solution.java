package Chapter_16_Intervals.lc_02_56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int lastEnd = result.get(result.size() - 1)[1];
            if (start <= lastEnd) {
                result.get(result.size() - 1)[1] = Math.max(lastEnd, end);
            } else {
                result.add(interval);
            }
        }
        return  result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {

    }
}

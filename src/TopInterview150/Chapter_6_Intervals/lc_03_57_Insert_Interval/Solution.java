package TopInterview150.Chapter_6_Intervals.lc_03_57_Insert_Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> combinedIntervals = new ArrayList<>();
        boolean newIntervalUsed = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (!newIntervalUsed && newInterval[0] < interval[0]) {
                combinedIntervals.add(newInterval);
                newIntervalUsed = true;
                i--;
            } else {
                combinedIntervals.add(interval);
            }
            if (!newIntervalUsed && i == intervals.length - 1) {
                combinedIntervals.add(newInterval);
            }
        }
        List<int[]> result = new ArrayList<>();
        result.add(combinedIntervals.get(0));
        for (int i = 1; i < combinedIntervals.size(); i++) {
            if (combinedIntervals.get(i)[0] <= result.get(result.size() - 1)[1]) {
                result.get(result.size() - 1)[1] = Math.max(combinedIntervals.get(i)[1], result.get(result.size() - 1)[1]);
            } else {
                result.add(combinedIntervals.get(i));
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.insert(new int[][]{{1, 5}}, new int[]{2, 7});
    }
}

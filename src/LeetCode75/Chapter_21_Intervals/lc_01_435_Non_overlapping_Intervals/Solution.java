package LeetCode75.Chapter_21_Intervals.lc_01_435_Non_overlapping_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, ((o1, o2) -> Integer.compare(o1[0], o2[0])));
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int begin = intervals[i][0];
            int end = intervals[i][1];
            int[] lastAdded = result.get(result.size() - 1);
            if (begin < lastAdded[1]){
                if (end < lastAdded[1]){
                    lastAdded[1] = end;
                }
            }
            else {
                result.add(intervals[i]);
            }
        }
        return intervals.length - result.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}

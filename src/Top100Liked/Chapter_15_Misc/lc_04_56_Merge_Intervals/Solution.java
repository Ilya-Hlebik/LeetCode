package Top100Liked.Chapter_15_Misc.lc_04_56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (list.get(list.size()-1)[1] >= intervals[i][0]) {
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], intervals[i][1]);
            }else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}

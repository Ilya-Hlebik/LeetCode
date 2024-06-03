package LeetCode75.Chapter_21_Intervals.lc_02_452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, ((o1, o2) -> Integer.compare(o1[0], o2[0])));
        List<int[]> intervals = new ArrayList<>();
        intervals.add(points[0]);
        for (int i = 1; i < points.length; i++) {
            int[] current = points[i];
            if (current[0]<= intervals.get(intervals.size()-1)[1]){
                int[] lastInterval = intervals.get(intervals.size() - 1);
                lastInterval[0] = Math.max(current[0], lastInterval[0]);
                lastInterval[1] = Math.min(current[1], lastInterval[1]);
            }
            else {
                intervals.add(current);
            }
        }

        return intervals.size();
    }
}

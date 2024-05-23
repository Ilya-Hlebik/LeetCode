package Interview_prepare.newrub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution14 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> Integer.compare(o1[0], o2[0])));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = result.get(result.size() - 1);
            if (lastInterval[1] >= intervals[i][0]) {
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}

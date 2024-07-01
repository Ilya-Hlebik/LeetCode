package TopInterview150.Chapter_6_Intervals.lc_02_56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> forMerge = new ArrayList<>();
        forMerge.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int begin = current[0];
            int end = current[1];
            int[] last = forMerge.get(forMerge.size()-1);
            if (last[1]>= begin){
                last[1] = Math.max(last[1], end);
            }
            else {
                forMerge.add(current);
            }
        }
       return forMerge.toArray(new int[forMerge.size()][2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[][]{{1,3}, {2,6}});
    }
}

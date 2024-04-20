package Chapter_16_Intervals.lc_01_57_Insert_Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList   = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1]<intervals[i][0]){
                resultList.add(newInterval);
                for (int j = i; j < intervals.length; j++){
                    resultList.add(intervals[j]);
                }
                return resultList.toArray(new int[resultList.size()][2]);
            }
            else if (newInterval[0]>intervals[i][1]){
                resultList.add(intervals[i]);
            }
            else {
                newInterval[0] = Math.min(     newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(     newInterval[1], intervals[i][1]);
            }
        }
        resultList.add(newInterval);
        return resultList.toArray(new int[resultList.size()][2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10},   {12, 16}}, new int[]{4, 8})));
    }
}

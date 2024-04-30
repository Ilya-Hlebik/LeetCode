package Chapter_16_Intervals.lc_06_1851_Minimum_Interval_to_Include_Each_Query;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[1] - o[0] + 1)));

        int result[] = new int[queries.length];
        Arrays.fill(result, -1);
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            for (int i = 0; i < queries.length; i++) {
                if (result[i] == -1) {
                    if (start <= queries[i] && end >= queries[i]) {
                        result[i] = end - start + 1;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.minInterval(new int[][]{{1, 4}, {2, 4}, {3, 6}, {4, 4}}, new int[]{2, 3, 4, 5})));
    }
}

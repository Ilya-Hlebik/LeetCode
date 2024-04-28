package Chapter_16_Intervals.lc_05_Meeting_Schedule2;

import Chapter_16_Intervals.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.minMeetingRooms(Arrays.asList(new Interval(1, 10), new Interval(2, 9),
                new Interval(3, 8), new Interval(5, 7), new Interval(6, 7))));
    }

    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for (Interval interval : intervals) {
            starts.add(interval.start);
            ends.add(interval.end);
        }
        Collections.sort(starts);
        Collections.sort(ends);
        int startIndex = 0;
        int endIndex = 0;
        int res = 0;
        int count = 0;
        while (startIndex < starts.size()) {
            if (starts.get(startIndex) < ends.get(endIndex)) {
                count++;
                startIndex++;
            } else {
                endIndex++;
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}

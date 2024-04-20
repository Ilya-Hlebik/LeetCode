package Chapter_16_Intervals.lc_04_Meeting_Schedule;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (Comparator.comparingInt(o -> o.start)));
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).start > intervals.get(i + 1).start || intervals.get(i).end > intervals.get(i + 1).start) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

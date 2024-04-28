package Chapter_16_Intervals.lc_05_Meeting_Schedule2;

import Chapter_16_Intervals.Interval;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minMeetingRooms(Arrays.asList(new Interval(1, 10), new Interval(2, 9),
                new Interval(3, 8), new Interval(5, 7), new Interval(6, 7))));
    }

    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 1) {
            return 1;
        }
        List<Interval> rooms = new ArrayList<>();
        Collections.sort(intervals, (Comparator.comparingInt(o -> o.start)));

        for (int i = 0; i < intervals.size(); i++) {
            if (rooms.isEmpty()) {
                rooms.add(intervals.get(i));
            } else {
                boolean isAdded = false;
                int minIndex = 0;
                int minValue = Integer.MAX_VALUE;
                for (int j = 0; j < rooms.size(); j++) {
                    if (rooms.get(j).end <= intervals.get(i).start) {
                        if (intervals.get(i).start - rooms.get(j).end < minValue){
                            minValue = intervals.get(i).start - rooms.get(j).end;
                            minIndex = j;
                            isAdded = true;
                        }
                    }
                }
                if (!isAdded) {
                    rooms.add(intervals.get(i));
                } else {
                    rooms.get(minIndex).end = intervals.get(i).end;
                }
            }
        }
        return rooms.size();
    }
}

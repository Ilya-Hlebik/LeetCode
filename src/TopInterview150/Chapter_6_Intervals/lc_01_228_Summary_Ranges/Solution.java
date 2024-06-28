package TopInterview150.Chapter_6_Intervals.lc_01_228_Summary_Ranges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int current = nums[0];
        Integer[] intervals = new Integer[2];
        intervals[0] = current;
        List<String> result = new ArrayList<>();
        for (int i = 1; i < nums.length + 1; i++) {
            if (i == nums.length || nums[i] != current + 1) {
                if (intervals[1] != null) {
                    result.add(intervals[0] + "->" + intervals[1]);
                } else {
                    result.add(String.valueOf(intervals[0]));
                }
                intervals[0] = null;
                intervals[1] = null;
            }
            if (i != nums.length) {
                if (intervals[0] == null) {
                    intervals[0] = (nums[i]);
                } else {
                    intervals[1] = (nums[i]);
                }
                current = nums[i];
            }
        }
        return result;
    }
}

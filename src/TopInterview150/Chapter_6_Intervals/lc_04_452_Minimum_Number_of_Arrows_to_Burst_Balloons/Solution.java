package TopInterview150.Chapter_6_Intervals.lc_04_452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1,o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> result =  new ArrayList<>();
        result.add(points[0]);
        for (int i = 1; i < points.length; i++) {
            if (result.get(result.size()-1)[1] >= points[i][0]){
                result.get(result.size()-1)[0] = Math.min(result.get(result.size()-1)[0], points[i][0]);
                result.get(result.size()-1)[1] =  Math.min(result.get(result.size()-1)[1], points[i][1]);
            }
            else {
                result.add(points[i]);
            }
        }
        return result.size();
    }
}

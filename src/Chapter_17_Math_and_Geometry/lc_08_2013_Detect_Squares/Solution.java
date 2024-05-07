package Chapter_17_Math_and_Geometry.lc_08_2013_Detect_Squares;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        detectSquares.count(new int[]{11, 10});
    }
}

class DetectSquares {
    Map<List<Integer>, Integer> map = new HashMap<>();

    public DetectSquares() {
    }

    public void add(int[] point) {
        map.put(Arrays.asList(point[0], point[1]), map.getOrDefault(Arrays.asList(point[0], point[1]), 0) + 1);
    }

    public int count(int[] point) {
        int count = 0;
        int px = point[0];
        int py = point[1];
        for (List<Integer> list : map.keySet()) {
            Integer x = list.get(0);
            Integer y = list.get(1);
            if (Math.abs(px - x) != Math.abs(py - y) || px == x || py == y) {
                continue;
            }
            if (map.containsKey(Arrays.asList(x, py)) && map.containsKey(Arrays.asList(px, y))) {
                count += map.get(list) * map.get(Arrays.asList(x, py)) * map.get(Arrays.asList(px, y));
            }
        }
        return count;
    }
}

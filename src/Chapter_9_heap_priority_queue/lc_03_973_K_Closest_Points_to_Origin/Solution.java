package Chapter_9_heap_priority_queue.lc_03_973_K_Closest_Points_to_Origin;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((o1, o2) -> {
            double value1 = Math.pow(o1.getKey(), 2) + Math.pow((o1.getValue()), 2);
            double value2 = Math.pow(o2.getKey(), 2) + Math.pow((o2.getValue()), 2);
            return Double.compare(value1, value2);
        });
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            minHeap.add(Map.entry(x,y));
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> poll = minHeap.poll();
            result [i][0] = poll.getKey();
            result [i][1] = poll.getValue();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.deepToString(solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2,4}}, 2)));
    }
}

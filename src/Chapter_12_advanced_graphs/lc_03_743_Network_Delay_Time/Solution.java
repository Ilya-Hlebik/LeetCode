package Chapter_12_advanced_graphs.lc_03_743_Network_Delay_Time;

import java.util.*;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times) {
            List<int[]> orDefault = edges.getOrDefault(time[0], new ArrayList<>());
            orDefault.add(new int[]{time[1], time[2]});
            edges.put(time[0], orDefault);
        }
        minHeap.add(new int[]{0, k});
        Set<Integer> visited = new HashSet<>();
        int t = 0;
        while (!minHeap.isEmpty()) {
            int[] poll = minHeap.poll();
            int w1 = poll[0];
            int n1 = poll[1];
            if (visited.contains(n1)) {
                continue;
            }
            visited.add(n1);
            t = Math.max(t, w1);

            List<int[]> neighbors = edges.getOrDefault(n1, new ArrayList<>());
            for (int[] neighbor : neighbors) {
                if (!visited.contains(neighbor[0])) {
                    minHeap.add(new int[]{neighbor[1] + w1, neighbor[0]});
                }
            }
        }
        return visited.size() == n ? t : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};

        System.out.println(solution.networkDelayTime(times, 4, 2));
    }
}

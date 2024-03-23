package Chapter_12_advanced_graphs.lc_02_1584_Min_Cost_to_Connect_All_Points;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution2 {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, 0 });
        int len = points.length;
        Set<Integer> visited = new HashSet<>();
        int cost = 0;
        while (visited.size() < len) {
            int[] arr = pq.poll();
            int weight = arr[0];
            int currNode = arr[1];
            if (visited.contains(currNode)) continue;
            visited.add(currNode);
            cost += weight;
            for (int nextNode = 0; nextNode < len; nextNode++) {
                if (!visited.contains(nextNode)) {
                    int nextWeight =
                            Math.abs(points[nextNode][0] - points[currNode][0]) +
                                    Math.abs(points[nextNode][1] - points[currNode][1]);
                    pq.offer(new int[] { nextWeight, nextNode });
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[][] data = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};


        System.out.println(solution.minCostConnectPoints(data));
    }
}

package Chapter_12_advanced_graphs.lc_06_787_Cheapest_Flights_Within_K_Stops;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[2], flight[1]});
        }
        int[] dis = new int[n];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;

        Queue<int[]> pq = new LinkedList<>();

        pq.add(new int[]{0, src});
        while (!pq.isEmpty()) {
            if (k == -1) {
                break;
            }
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                int[] poll = pq.poll();
                int distance = poll[0];
                int node = poll[1];
                for (int[] ints : adj.get(node)) {
                    if (distance + ints[0] < dis[ints[1]]) {
                        dis[ints[1]] = distance + ints[0];
                        pq.add(new int[]{dis[ints[1]], ints[1]});
                    }
                }
            }
            k--;
        }
        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] list = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        System.out.println(solution.findCheapestPrice(4, list, 0, 3, 1));
    }
}

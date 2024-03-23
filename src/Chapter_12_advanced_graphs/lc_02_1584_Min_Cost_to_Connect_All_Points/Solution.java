package Chapter_12_advanced_graphs.lc_02_1584_Min_Cost_to_Connect_All_Points;

import java.util.*;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points.length == 1) {
            return 0;
        }
        List<List<Map.Entry<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(Map.entry(dist, j));
                adj.get(j).add(Map.entry(dist, i));
            }
        }
        int res = 0;
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minH = new PriorityQueue<>(Map.Entry.comparingByKey());
        minH.add(Map.entry(0, 0));
        while (visit.size() < points.length) {
            Map.Entry<Integer, Integer> poll = minH.poll();
            if (visit.contains(poll.getValue())) {
                continue;
            }
            res += poll.getKey();
            visit.add(poll.getValue());
            List<Map.Entry<Integer, Integer>> entries = adj.get(poll.getValue());
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (!visit.contains(entry.getValue())) {
                    minH.add(entry);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] data = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};


        System.out.println(solution.minCostConnectPoints(data));
    }
}

class ArraysComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        int compareFirst = Integer.compare(o1[0], o2[0]);
        if (compareFirst == 0) {
            return Integer.compare(o1[1], o2[1]);
        }
        return compareFirst;
    }
}

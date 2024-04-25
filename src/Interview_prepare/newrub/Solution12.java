package Interview_prepare.newrub;

import java.util.*;

public class Solution12 {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{k, 0});
        for (int[] time : times) {
            Map<Integer, Integer> orDefault = map.getOrDefault(time[0], new HashMap<>());
            orDefault.put(time[1], time[2]);
            map.put(time[0], orDefault);
        }
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currNode = poll[0];
            int currWeight = poll[1];
            Map<Integer, Integer> currentMap = map.get(currNode);
            if (currentMap != null) {
                for (Integer next : currentMap.keySet()) {
                    int nextWeight = map.get(currNode).get(next);

                    if (nextWeight + currWeight < dis[next]) {
                        dis[next] = nextWeight + currWeight;
                        queue.add(new int[]{next, nextWeight + currWeight});
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i < dis.length; i++) {
            res = Math.max(res, dis[i]);
        }
        return res == Integer.MAX_VALUE? -1:res;
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        System.out.println(solution12.networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}}, 3, 1));
    }

}

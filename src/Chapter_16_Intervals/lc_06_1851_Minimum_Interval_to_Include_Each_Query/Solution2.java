package Chapter_16_Intervals.lc_06_1851_Minimum_Interval_to_Include_Each_Query;

import java.util.*;

public class Solution2 {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((o1, o2) -> {
            int compare = Integer.compare(o1.getKey(), o2.getKey());
            if (compare == 0) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
            return compare;
        });
        List<Query> sortedQueries = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            sortedQueries.add(new Query(queries[i], i));
        }
        Collections.sort(sortedQueries, Comparator.comparingInt(o -> o.query));
        int [] result = new int[queries.length];
        Arrays.fill(result, -1);
        int i = 0;
        for (Query sortedQuery : sortedQueries) {
            while (i < intervals.length && intervals[i][0] <= sortedQuery.query) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.add(Map.entry(r - l + 1, r));
                i++;
            }
            while (!minHeap.isEmpty() && minHeap.peek().getValue() < sortedQuery.query){
                minHeap.poll();
            }
            if (!minHeap.isEmpty()){
                result[sortedQuery.index] = minHeap.peek().getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.minInterval(new int[][]{{1, 4}, {2, 4}, {3, 6}, {4, 4}}, new int[]{2, 3, 4, 5})));
    }
}

class Query {
    int query;
    int index;

    public Query(int query, int index) {
        this.query = query;
        this.index = index;
    }
}

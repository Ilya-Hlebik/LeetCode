package TopInterview150.Chapter_19_Heap.lc_02_502_IPO;

import java.util.*;

public class Solution2 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            pairs.add(new int[]{profits[i], capital[i]});
        }
        pairs.sort(Comparator.comparingInt(o -> o[1]));

        int i = 0;
        while (i < pairs.size() && k > 0) {
            for (; i < pairs.size() && w >= pairs.get(i)[1]; i++) {
                heap.add(pairs.get(i)[0]);
            }
            if (heap.isEmpty()) {
                return w;
            }
            w += heap.poll();
            k--;
        }
        return w;
    }
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
    }
}

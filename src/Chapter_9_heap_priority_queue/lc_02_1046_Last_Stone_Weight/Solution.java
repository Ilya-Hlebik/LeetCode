package Chapter_9_heap_priority_queue.lc_02_1046_Last_Stone_Weight;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            heap.add(stone);
        }
        while (heap.size() >1){
            Integer y = heap.poll();
            Integer x = heap.poll();
            if (!x.equals(y)){
                heap.add(y-x);
            }
        }
        return heap.isEmpty()?0: heap.poll();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}

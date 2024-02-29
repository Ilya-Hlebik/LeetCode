package Chapter_9_heap_priority_queue.lc_05_621_Task_Scheduler;

import java.util.*;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((Comparator.reverseOrder()));
        int []arr = new int[26];
        for (char task : tasks) {
            arr[task- 'A']++;
        }
        for (int i : arr) {
            if (i!= 0){
                minHeap.add(i);
            }
        }
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        int count = 0;
        while (!minHeap.isEmpty() || !queue.isEmpty()) {
            count++;
            if (!minHeap.isEmpty()) {
                Integer poll = minHeap.poll() - 1;
                if (poll > 0) {
                    queue.add(Map.entry(poll, n + count));
                }
            }
            if (!queue.isEmpty() && queue.peek().getValue() == count) {
                minHeap.add(queue.poll().getKey());
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}

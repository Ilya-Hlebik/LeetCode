package Chapter_9_heap_priority_queue.lc_08_373_Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.get(0) + o.get(1)));
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums1.length && i < k; i++) queue.offer(List.of(nums1[i], nums2[0], 0));
        while (k-- > 0 && !queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            result.add(List.of(poll.get(0), poll.get(1)));
            if (poll.get(2) < nums2.length - 1) {
                int next = poll.get(2) + 1;
                queue.add(List.of(poll.get(0), nums2[next], next));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kSmallestPairs(new int[]{1, 2, 4, 5, 6}, new int[]{3, 5, 7, 9}, 20));
    }
}

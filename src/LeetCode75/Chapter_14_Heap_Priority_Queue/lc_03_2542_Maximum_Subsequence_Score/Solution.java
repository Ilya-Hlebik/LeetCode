package LeetCode75.Chapter_14_Heap_Priority_Queue.lc_03_2542_Maximum_Subsequence_Score;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] ess = new int[n][2];
        for (int i = 0; i < n; i++) {
            ess[i] = new int[]{nums2[i], nums1[i]};
        }
        Arrays.sort(ess, (a, b) -> Integer.compare(b[0], a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long res = 0, sumS = 0;
        for (int[] ints : ess) {
            pq.add(ints[1]);
            sumS += ints[1];
            if (pq.size() > k) {
                sumS -= pq.poll();
            }
            if (pq.size() == k) {
                res = Math.max(res, (sumS) * ints[0]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxScore(new int[]{1, 3, 3, 2}, new int[]{2, 1, 3, 4}, 3));
    }
}

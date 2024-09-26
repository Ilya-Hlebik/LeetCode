package TopInterview150.Chapter_19_Heap.lc_03_373_Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0] + o[1]));
        for (int i = 0; i < nums1.length; i++) {
            heap.add(new int[]{nums1[i], nums2[0], 0});
        }
        List<List<Integer>> result = new ArrayList<>();
        while (k > 0) {
            int[] poll = heap.poll();
            result.add(List.of(poll[0], poll[1]));
            int nums2Index = poll[2];
            if (nums2Index < nums2.length - 1) {
                heap.add(new int[]{poll[0], nums2[nums2Index + 1], nums2Index + 1});
            }
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
    }
}

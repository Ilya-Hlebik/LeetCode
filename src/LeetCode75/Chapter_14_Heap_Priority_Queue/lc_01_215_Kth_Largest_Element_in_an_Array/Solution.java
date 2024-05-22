package LeetCode75.Chapter_14_Heap_Priority_Queue.lc_01_215_Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num: nums){
            heap.add(num);
            if (heap.size()>k){
                heap.poll();
            }
        }
        return heap.poll();
    }
}

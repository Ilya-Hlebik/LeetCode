package Top100Liked.Chapter_8_Heap.lc_01_215_Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>( );
        for (int num : nums) {
            queue.add(num);
            if (queue.size()>k){
                queue.poll();
            }
        }
        return queue.poll();
    }
}

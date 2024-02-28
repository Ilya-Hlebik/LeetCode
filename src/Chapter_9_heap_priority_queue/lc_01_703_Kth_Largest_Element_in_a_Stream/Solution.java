package Chapter_9_heap_priority_queue.lc_01_703_Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}

class KthLargest {
    private final Queue<Integer> heap = new PriorityQueue<>();
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
             add(num);
        }
    }

    public int add(int val) {
        if (k > heap.size()){
            heap.add(val);
        }
        else if (val > heap.peek()){
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }
}

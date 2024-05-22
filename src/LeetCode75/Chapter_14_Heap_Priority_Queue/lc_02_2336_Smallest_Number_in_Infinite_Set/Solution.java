package LeetCode75.Chapter_14_Heap_Priority_Queue.lc_02_2336_Smallest_Number_in_Infinite_Set;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
}

class SmallestInfiniteSet {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    Set<Integer> elements = new HashSet<>();

    public SmallestInfiniteSet() {
        for(int  i = 1; i<= 1000; i++){
            heap.add(i);
            elements.add(i);
        }
    }

    public int popSmallest() {
        Integer poll = heap.poll();
        elements.remove(poll);
        return poll;
    }

    public void addBack(int num) {
        if (!elements.contains(num)) {
            elements.add(num);
            heap.add(num);
        }
    }
}

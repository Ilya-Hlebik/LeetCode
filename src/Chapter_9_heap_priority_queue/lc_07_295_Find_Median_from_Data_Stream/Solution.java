package Chapter_9_heap_priority_queue.lc_07_295_Find_Median_from_Data_Stream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);    // arr = [1]
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((Comparator.reverseOrder()));

    public MedianFinder() {

    }

    public void addNum(int num) {
        maxHeap.add(num);
        if (maxHeap.size() - minHeap.size() > 1 || minHeap.size()!= 0 && maxHeap.peek()> minHeap.peek()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        int totalSize = minHeap.size() + maxHeap.size();
        if (totalSize % 2 == 0) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }
}

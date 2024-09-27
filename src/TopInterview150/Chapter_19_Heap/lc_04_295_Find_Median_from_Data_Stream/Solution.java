package TopInterview150.Chapter_19_Heap.lc_04_295_Find_Median_from_Data_Stream;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder {
    PriorityQueue<Double> minHeap = new PriorityQueue<>();
    PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


    public MedianFinder() {

    }

    public void addNum(int num) {
        maxHeap.add((double) num);
        if (maxHeap.size() - minHeap.size() > 1 || minHeap.size() != 0 && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if ((minHeap.size() + maxHeap.size()) % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }
}

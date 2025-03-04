package Top100Liked.Chapter_8_Heap.lc_02_295_Find_Median_from_Data_Stream;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        MedianFinder solution = new MedianFinder();
        solution.addNum(  1);
        System.out.println(solution.findMedian());
        solution.addNum(  2);
        System.out.println(solution.findMedian());
        solution.addNum(  3);
        System.out.println(solution.findMedian());
       /* solution.addNum(-4);
        System.out.println(solution.findMedian());
        solution.addNum(-5);
        System.out.println(solution.findMedian());*/
    }

}

class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2, o1)));

    public MedianFinder() {

    }

    public void addNum(int num) {
        minHeap.add(num);
        if (minHeap.size() - maxHeap.size() > 1 || (!maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek())) {
            maxHeap.add(minHeap.poll());
        }
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if ((minHeap.size() + maxHeap.size()) % 2 == 0) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
        if (minHeap.size()> maxHeap.size()){
            return minHeap.peek();
        }
        return maxHeap.peek();
    }
}

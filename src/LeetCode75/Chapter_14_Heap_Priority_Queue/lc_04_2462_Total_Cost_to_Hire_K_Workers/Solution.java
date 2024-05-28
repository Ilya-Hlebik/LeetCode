package LeetCode75.Chapter_14_Heap_Priority_Queue.lc_04_2462_Total_Cost_to_Hire_K_Workers;

import java.util.PriorityQueue;

public class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int i = 0;
        int j = costs.length - 1;
        long total = 0;
        while (k > 0) {
            while (left.size() < candidates && i <= j) {
                left.add(costs[i++]);
            }
            while (right.size() < candidates && i <= j) {
                right.add(costs[j--]);
            }
            int val1 = left.size() > 0 ? left.peek() : Integer.MAX_VALUE;
            int val2 = right.size() > 0 ? right.peek() : Integer.MAX_VALUE;

            if (val1<= val2){
                total +=left.poll();
            }
            else {
                total +=right.poll();
            }

            k--;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalCost(new int[]{31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58}, 11, 2));
    }
}

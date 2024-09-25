package TopInterview150.Chapter_19_Heap.lc_02_502_IPO;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Capital> heap = new PriorityQueue<>((o1, o2) -> {
            int firstCompare = Integer.compare(o2.profit, o1.profit);
            if (firstCompare == 0){
               return Integer.compare(o1.capital, o2.capital);
            }
            return firstCompare;
        });
        for (int i = 0; i < profits.length; i++) {
            heap.add(new Capital(profits[i], capital[i]));
        }
        while (!heap.isEmpty() && k>0) {
            List<Capital> temp = new ArrayList<>();
            Capital poll = heap.poll();
            while (poll.capital > w) {
                temp.add(poll);
                if (heap.isEmpty()){
                    poll = null;
                    break;
                }
                poll = heap.poll();
            }
            if (poll == null){
                return w;
            }
            w += poll.profit;
            heap.addAll(temp);
            k--;
        }
        return w;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaximizedCapital(1, 0, new int[]{1, 2, 3}, new int[]{1, 1, 2}));
    }
}

class Capital {
    int profit;
    int capital;

    public Capital(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Capital{" +
                "profit=" + profit +
                ", capital=" + capital +
                '}';
    }
}

package LeetCode75.Chapter_7_Queue.lc_01_933_Number_of_Recent_Calls;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        recentCounter.ping(1);
    }
}
class RecentCounter {
    Queue<Integer> calls = new LinkedList<>();
    public RecentCounter() {

    }

    public int ping(int t) {
        calls.add(t);
        int left = t- 3000;
        while (calls.peek()< left){
            calls.poll();
        }
        return calls.size();
    }
}

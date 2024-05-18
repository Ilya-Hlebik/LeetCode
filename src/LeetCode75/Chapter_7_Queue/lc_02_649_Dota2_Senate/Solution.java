package LeetCode75.Chapter_7_Queue.lc_02_649_Dota2_Senate;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.predictPartyVictory("RDD");
    }

    public String predictPartyVictory(String senate) {
        Queue<Integer> dire = new LinkedList<>();
        Queue<Integer> radiant = new LinkedList<>();
        char[] chars = senate.toCharArray();
        for (int i = 0; i < senate.length(); i++) {
            if (chars[i] == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }
        int i = senate.length();
        while (!dire.isEmpty() && !radiant.isEmpty()) {
            Integer direPoll = dire.poll();
            Integer radiantPoll = radiant.poll();
            if (direPoll<radiantPoll){
                dire.add(i++);
            }
            else {
                radiant.add(i++);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }
}

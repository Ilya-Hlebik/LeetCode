package freeRun.lc_79_319_Bulb_Switcher;

public class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.bulbSwitch(99999999);
    }

}

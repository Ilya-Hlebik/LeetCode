package TopInterview150.Chapter_5_HashMap.lc_07_202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> loopNumbers = new HashSet<>();
        int amount = 0;
        while (true){
            while (n>0) {
                amount += Math.pow(n % 10, 2);
                n/=10;
            }
            if (loopNumbers.contains(amount)){
                return false;
            }
            else {
                if (amount == 1){
                    return true;
                }
                loopNumbers.add(amount);
                n = amount;
                amount = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isHappy(19);
    }
}

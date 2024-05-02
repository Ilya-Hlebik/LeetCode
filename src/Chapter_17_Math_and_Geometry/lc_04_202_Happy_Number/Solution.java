package Chapter_17_Math_and_Geometry.lc_04_202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        int res = 0;
        Set<Integer> usedNumbers = new HashSet<>();
        while (res != 1) {
            if (usedNumbers.contains(n)) {
                return false;
            }
            usedNumbers.add(n);
            res = 0;
            while (n != 0) {
                res += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = res;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(2));
    }
}

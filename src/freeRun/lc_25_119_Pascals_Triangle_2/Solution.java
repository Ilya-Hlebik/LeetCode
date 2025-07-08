package freeRun.lc_25_119_Pascals_Triangle_2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long prev = 1;
        result.add((int) prev);
        for (int i = 1; i <= rowIndex; i++) {
            long val = prev * (rowIndex + 1 - i) / i;
            result.add((int)val);
            prev = val;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(4));
    }
}

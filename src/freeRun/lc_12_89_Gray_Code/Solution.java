package freeRun.lc_12_89_Gray_Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0));
        for (int i = 1; i <= n; i++) {
            List<Integer> reversed = new ArrayList<>(result);
            Collections.reverse(reversed);
            int val = (int) Math.pow(2, i - 1);
            for (Integer integer : reversed) {
                result.add(integer + val);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.grayCode(2));
    }
}

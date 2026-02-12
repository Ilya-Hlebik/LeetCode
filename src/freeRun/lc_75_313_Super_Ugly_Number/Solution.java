package freeRun.lc_75_313_Super_Ugly_Number;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pointers = new int[primes.length];
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        while (uglyNumbers[n - 1] == 0) {
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < primes.length; i++) {
                int prime = primes[i];
                int candidate = prime * uglyNumbers[pointers[i]];
                list.add(new int[]{candidate, i});
            }
            list.sort(Comparator.comparingInt(o -> o[0]));
            int min = list.get(0)[0];
            for (int[] ints : list) {
                if (ints[0] == min) {
                    pointers[ints[1]]++;
                } else {
                    break;
                }
            }
        }
        return uglyNumbers[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nthSuperUglyNumber(12, new int[]{2,7,13,19});
    }
}

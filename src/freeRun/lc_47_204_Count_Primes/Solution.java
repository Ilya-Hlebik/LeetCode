package freeRun.lc_47_204_Count_Primes;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public int countPrimes(int n) {
        Map<Integer, Boolean> map = new LinkedHashMap<>();
        for (int i =2; i< n; i++){
            map.put(i, true);
        }
        for (Map.Entry<Integer, Boolean> el : map.entrySet()) {
            if (Math.pow(el.getKey(), 2)>n){
                break;
            }
            for (int i = el.getKey() + el.getKey(); i< n; i+=el.getKey()){
                map.put(i, false);
            }
        }
        return (int) map.entrySet().stream().filter(Map.Entry::getValue).count();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(10));
    }
}

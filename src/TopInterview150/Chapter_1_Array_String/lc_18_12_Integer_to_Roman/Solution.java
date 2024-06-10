package TopInterview150.Chapter_1_Array_String.lc_18_12_Integer_to_Roman;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    public String intToRoman(int num) {
        List<Map.Entry<Character, Integer>> map = new ArrayList<>();
        map.add(Map.entry('I', 1));
        map.add(Map.entry('V', 5));
        map.add(Map.entry('X', 10));
        map.add(Map.entry('L', 50));
        map.add(Map.entry('C', 100));
        map.add(Map.entry('D', 500));
        map.add(Map.entry('M', 1000));
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            if (String.valueOf(num).charAt(0) != '4' && String.valueOf(num).charAt(0) != '9') {
                for (int i = map.size() - 1; i >= 0; i--) {
                    if (num - map.get(i).getValue() >= 0) {
                        res.append(map.get(i).getKey());
                        num -= map.get(i).getValue();
                        break;
                    }
                }
            } else {
                if (num <= 10) {
                    for (int i = map.size() - 1; i >= 0; i--) {
                        if (num - map.get(i).getValue() == -1) {
                            res.append('I');
                            res.append(map.get(i).getKey());
                            num  = num -  map.get(i).getValue() + 1;
                            break;
                        }
                    }
                } else if (num <= 100) {
                    for (int i = map.size() - 1; i >= 0; i--) {
                        if (num - map.get(i).getValue() >=-10) {
                            res.append('X');
                            res.append(map.get(i).getKey());
                            num  =num -  map.get(i).getValue() + 10;
                            break;
                        }
                    }
                } else if (num <= 1000) {
                    for (int i = map.size() - 1; i >= 0; i--) {
                        if (num - map.get(i).getValue() >= -100) {
                            res.append('C');
                            res.append(map.get(i).getKey());
                            num = num - map.get(i).getValue() + 100;
                            break;
                        }
                    }
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(58));
    }
}

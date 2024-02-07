package binary_search.lc_06_981_Time_Based_Key_Value_Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));
    }
}

class TimeMap {
    Map<String, List<Map.Entry<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Map.Entry<Integer, String>> valueList = map.getOrDefault(key, new ArrayList<>());
        valueList.add(Map.entry(timestamp, value));
        map.put(key, valueList);
    }

    public String get(String key, int timestamp) {
        String result = "";
        if (map.containsKey(key)) {
            List<Map.Entry<Integer, String>> entries = map.get(key);
            int min = 0;
            int max = entries.size() - 1;
            int currentIndex = Integer.MIN_VALUE;
            while (max >= min) {
                int mid = min + (max - min) / 2;
                Map.Entry<Integer, String> midValue = entries.get(mid);
                if (midValue.getKey() == timestamp) {
                    return midValue.getValue();
                } else if (midValue.getKey() < timestamp) {
                    currentIndex = Math.max(currentIndex, mid);
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
            if (currentIndex != Integer.MIN_VALUE){
                result = entries.get(currentIndex).getValue();
            }
        }
        return result;
    }
}

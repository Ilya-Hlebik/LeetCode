package TopInterview150.Chapter_1_Array_String.lc_12_380_Insert_Delete_GetRandom_O_1;

import java.util.*;

public class Solution {
}

class RandomizedSet {
    List<Pair> randomValues = new ArrayList<>();
    Map<Integer, Integer> values = new HashMap<>();
    Random random = new Random();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (!values.containsKey(val)) {
            randomValues.add(new Pair(val, true));
            values.put(val, randomValues.size() - 1);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (!values.containsKey(val)) {
            return false;
        }
        Integer integer = values.get(val);
        Pair integerBooleanEntry = randomValues.get(integer);
        integerBooleanEntry.setValue(false);
        values.remove(val);
        return true;
    }

    public int getRandom() {
        int size = randomValues.size();
        while (true) {
            int index = random.nextInt(size);
            Pair integerBooleanEntry = randomValues.get(index);
            if (integerBooleanEntry.getValue()) {
                return integerBooleanEntry.getKey();
            }
        }
    }
}
class Pair {
    Integer key;
    Boolean value;

    public Pair(Integer key, Boolean value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}

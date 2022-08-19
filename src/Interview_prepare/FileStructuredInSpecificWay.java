package Interview_prepare;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileStructuredInSpecificWay {
    public static void main(String[] args) {
        JUnitCore.main("");
    }

    public List<String> getUsersByKey(Map<String, Pair<String, String>> map, String key) {

        return map.entrySet().stream()
                .filter((entry) -> entry.getValue().getKey().equals(key))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Test
    public void test() {
        FileStructuredInSpecificWay solution = new FileStructuredInSpecificWay();
        Map<String, Pair<String, String>> testMap = new HashMap<>();
        testMap.put("User1", Pair.of("X", "y"));
        testMap.put("User2", Pair.of("Z", "y"));
        testMap.put("User3", Pair.of("X", "y"));
        List<String> result = solution.getUsersByKey(testMap, "X");
        Assert.assertEquals(result, Arrays.asList("User1", "User3"));
    }

}

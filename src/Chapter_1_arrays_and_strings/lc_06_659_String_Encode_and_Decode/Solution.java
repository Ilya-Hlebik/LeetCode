package Chapter_1_arrays_and_strings.lc_06_659_String_Encode_and_Decode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Solution {
    Integer delimiter;

    public String encode(List<String> strs) {
        delimiter = strs.hashCode();
        return Optional.of(strs).filter(strings -> !strings.isEmpty()).map(strings -> strings.stream()
                .collect(java.util.stream.Collectors.joining(String.valueOf(delimiter)))).orElse(null);
    }

    public List<String> decode(String str) {
        return Optional.ofNullable(str).map(s -> Arrays.stream(s.split(String.valueOf(delimiter))).collect(java.util.stream.Collectors.toList())).orElse(new ArrayList<>());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> input = List.of( );
        String encode = solution.encode(input);
        List<String> decode = solution.decode(encode);
        System.out.println(decode);
    }
}

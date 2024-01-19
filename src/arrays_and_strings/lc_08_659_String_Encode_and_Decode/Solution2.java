package arrays_and_strings.lc_08_659_String_Encode_and_Decode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {
    public String encode(List<String> strs) {
        return strs.stream().map(s -> s.length() + "#" + s).collect(Collectors.joining());
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        for (int i = 0, j = 0; i < str.length() && j < str.length(); j++) {
            char letter = str.charAt(j);
            if (letter != '#') {
                continue;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + +1 + length;
            String substring = str.substring(j + 1, i);
            result.add(substring);
            j = i - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        List<String> input = List.of("neet","code","love","you");
        String encode = solution.encode(input);
        List<String> decode = solution.decode(encode);
        System.out.println(decode);
    }
}

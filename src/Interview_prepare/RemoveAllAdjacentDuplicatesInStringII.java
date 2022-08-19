package Interview_prepare;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveAllAdjacentDuplicatesInStringII {
    public static void main(String[] args) {

        RemoveAllAdjacentDuplicatesInStringII sol = new RemoveAllAdjacentDuplicatesInStringII();
        System.out.println(sol.removeDuplicates("deeedbbcccbdaa", 3));
    }

    public String removeDuplicates(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int count[] = new int[s.length()];
        for (char c : s.toCharArray()) {
            stringBuilder.append(c);
            int last = stringBuilder.length() - 1;
            count[last] = 1 + (last > 0 && stringBuilder.charAt(last) == stringBuilder.charAt(last - 1) ? count[last - 1] : 0);
            if (count[last] >= k) {
                stringBuilder.delete(stringBuilder.length() - k, stringBuilder.length());
            }
        }
        return stringBuilder.toString();
    }

    public String removeDuplicates2(String s, int k) {


        while (true) {
            List<Pair<String, Integer>> letters = new ArrayList<>();
            int arrayIndex = 0;
            for (int i = 0; i < s.length(); i++) {
                String currentLetter = String.valueOf(s.charAt(i));
                if (i == 0) {
                    letters.add(Pair.of(currentLetter, 1));
                    continue;
                }
                if (currentLetter.equals(letters.get(arrayIndex).getLeft())) {
                    Pair<String, Integer> currentPair = letters.get(arrayIndex);
                    letters.set(arrayIndex, Pair.of(currentPair.getKey(), currentPair.getValue() + 1));
                } else {
                    arrayIndex++;
                    letters.add(Pair.of(currentLetter, 1));
                }
            }
            List<String> lettersForRemove = letters.stream()
                    .filter(pair -> pair.getRight() >= k)
                    .map(Pair::getKey)
                    .collect(Collectors.toList());
            if (lettersForRemove.size() == 0) {
                break;
            }
            for (int i = 0; i < lettersForRemove.size(); i++) {
                s = s.replaceAll(computeValue(lettersForRemove.get(i), k), "");
            }
        }
        return s;
    }

    private String computeValue(String letter, int k) {
        String result = "";
        for (int i = 0; i < k; i++) {
            result += letter;
        }
        return result;
    }

}

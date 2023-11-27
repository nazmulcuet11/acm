package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode784 {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        generatePermutations(s, 0, "", ans);
        return ans;
    }

    private void generatePermutations(
            String original,
            int index,
            String current,
            List<String> ans
    ) {
        if (index >= original.length()) {
            ans.add(current);
            current = "";
            return;
        }

        char ch = original.charAt(index);
        if (Character.isLetter(ch)) {
            generatePermutations(original, index + 1, current + Character.toLowerCase(ch), ans);
            generatePermutations(original, index + 1, current + Character.toUpperCase(ch), ans);
        } else {
            generatePermutations(original, index + 1, current + ch, ans);
        }
    }
}

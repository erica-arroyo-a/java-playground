import java.util.*;

public class PhoneNumberLetterCombination {
    // phone keys
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        // check for empty, constraints check
        if (digits.length() == 0 || digits.length() > 4) return res;
        combination("", digits, 0, res);

        return res;
    }

    // helper function, with recursion
    private void combination(String prefix, String digits, int offset, List<String> res) {
        if (offset >= digits.length()) {
            res.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, res);
        }
    }
}

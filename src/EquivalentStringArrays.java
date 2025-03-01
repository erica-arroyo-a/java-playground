/**
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 * A string is represented by an array if the array elements concatenated in order forms the string.
 *
 * Example 1:
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 * Output: true
 * Explanation:
 * word1 represents string "ab" + "c" -> "abc"
 * word2 represents string "a" + "bc" -> "abc"
 * The strings are the same, so return true.
 *
 * Example 2:
 * Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 * Output: false
 *
 * Example 3:
 * Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * Output: true
 */
public class EquivalentStringArrays {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (String w : word1) {
            s1.append(w);
        }

        for (String w : word2) {
            s2.append(w);
        }

        return s1.toString().equals(s2.toString());
    }

    public boolean arrayStringsAreEqualV2(String[] word1, String[] word2) {
        String s1 = "";
        String s2 = "";
        for (String s:word1) s1 += s;
        for (String s:word2) s2 += s;
        return s1.equals(s2);
    }
}

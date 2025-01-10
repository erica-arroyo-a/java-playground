import java.util.Arrays;

public class LongestCommonPrefix {

    /*
        Example 1:
        Input: strs = ["flower","flow","flight"]
        Output: "fl"

        Example 2:
        Input: strs = ["dog","racecar","car"]
        Output: ""
     */

    public String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        // return empty if array is empty or any string is empty
        if (size == 0 || Arrays.stream(strs).anyMatch(String::isEmpty)) return "";

        String prefix = strs[0]; // start with the first string

        for (int i = 1; i < size; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }

        return prefix;
    }
}

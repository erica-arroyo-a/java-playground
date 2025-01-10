import java.util.*;

public class Palindrome {

    public static void main(String[] args) {
        String test = "aacbbcaa";
        String test2 = "geek";
        String test3 = "sorta";
        String test4 = "abba";
        boolean result = isPalindrome(test);
        boolean result2 = isPalindrome(test2);
        boolean result3 = isPalindrome(test3);
        boolean result4 = isPalindrome(test4);
        boolean result5 = isPalindromeV2(test);
        boolean result6 = isPalindromeV2(test2);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
    }

    public static boolean isPalindrome(String str) {
        // ignore casing and exclude special chars and spaces
        String temp = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        // pointers
        int i = 0; // start of string
        int j = str.length() - 1; // end of string

        // check if each char is equals and traverse towards the middle of the string
        while (i < j) {
            if (temp.charAt(i) != temp.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindromeV2(String str) {
        StringBuilder input = new StringBuilder();
        input.append(str);
        input.reverse();

        return input.toString().equals(str);
    }
}

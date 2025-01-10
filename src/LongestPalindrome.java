class LongestPalindrome {

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";

        String r1 = longestPalindrome(s1);
        String r2 = longestPalindrome(s2);

        System.out.println(r1);
        System.out.println(r2);
    }
    //helper function
    public static boolean isPalindrome(String s, int left, int right) {
        // check if each char is equals and traverse towards the middle of the string
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        int max = 1, start = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                int current = j - i + 1;
                if (isPalindrome(s, i, j) && current > max) {
                    max = current;
                    start = i;
                }
            }
        }

        return s.substring(start, start + max);
    }
}

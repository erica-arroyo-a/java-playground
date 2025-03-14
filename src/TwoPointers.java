// Template for how to set up two pointers in a string
class TwoPointers {
    static void twoPointers(String s1) {
        int left = 0;
        int right = s1.length() - 1;
        while (left <= right) {
            left = left + 1;
            right = right - 1;
        }
    }
}
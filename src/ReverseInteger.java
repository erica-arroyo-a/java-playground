class ReverseInteger {
    /*
        Input: x = 123
        Output: 321

        Input: x = -123
        Output: -321

        Input: x = 120
        Output: 21
     */
    public static void main(String[] args) {
        int a = 123;
        int b = -123;
        int c = 120;

        int r1 = reverse(a);
        int r2 = reverse(b);
        int r3 = reverse(c);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
    }
    // helper function
    public static boolean isWithin32BitRange(long num) {
        return num >= Integer.MIN_VALUE && num <= Integer.MAX_VALUE;
    }

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder(Integer.toString(x));
        long number = 0;
        // check for negative numbers
        if (sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
            sb.reverse();
            long pos = Long.parseLong(sb.toString());
            number = -pos;
        } else {
            sb.reverse();
            number = Long.parseLong(sb.toString());
        }

        if (!isWithin32BitRange(number)) {
            return 0;
        }

        return (int) number;
    }
}

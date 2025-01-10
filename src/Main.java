import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public class Main {

    public static class Student {
        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        YearMonth yearMonthObject = YearMonth.of(1999, 2);
        int daysInMonth = yearMonthObject.lengthOfMonth(); //28
        LocalDate date = LocalDate.now();
        LocalDate firstDay = firstDayOfMonth(date);
        LocalDate lastDay = lastDayOfMonth(date);
        System.out.println(firstDay);
        System.out.println(lastDay);

        Student s = new Student("erica", 30);
    }

    private static void collections() {
        // Array list
        ArrayList<String> al = new ArrayList<>();
        al.add("Erica");
        al.add("Arroyo");

        Iterator itr = al.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Linked list
        LinkedList<String> ll = new LinkedList<>();
        ll.add("one");
        ll.add("two");

        for (String s : ll) {
            System.out.println(s);
        }

    }

    private static LocalDate firstDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }

    private static LocalDate lastDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }

    private static LocalDate nextDay(LocalDate date) {
        return date.plusDays(1);
    }

    public static boolean isPalindrome(String str) {
        String input = str.toLowerCase();
        StringBuilder rev = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            rev.append(input.charAt(i));
        }

        // Checking if both the strings are equal
        return input.equals(rev.toString());
    }

    public static boolean isPalindromeRecursion(String s) {
        String input = s.toLowerCase();
        // if length is 0 or 1 then String is palindrome
        if (input.length() == 0 || input.length() == 1)
            return true;
        if (input.charAt(0) == input.charAt(s.length() - 1))
            /* check for first and last char of String:
             * if they are same then do the same thing for a substring
             * with first and last char removed. and carry on this
             * until you string completes or condition fails
             */
            return isPalindromeRecursion(input.substring(1, input.length() - 1));

        return false;
    }

    //Given a binary tree represented as an array, for example, [3,6,2,9,-1,10] represents a binary tree and -1 is a
    // non existent node. Write a function that determines whether the left or right branch of the ree is larger.
    // The size of each branch s the sum of the node values. The function should return the string "Right" if the right
    // size is larger and "Left" if the left size is larger. If the tree has 0 nodes of it the size of the branches
    // are equal, return the empty string. i.e. function public String findLargeTree(long[] arr)
    // i.e. [3,6,2,9,-1,10] returns "Left". [1,10,5,1,0,6] returns ""

    public static String getBiggerSubtree(int[] arr) {
        if (arr == null || arr.length == 0) return "";
        int leftSum;
        int rightSum;

        int left = 1;
        int right = 2;

        leftSum = getTreeSum(arr, left);
        rightSum = getTreeSum(arr, right);

        if (leftSum > rightSum) return "Left";
        else if (leftSum < rightSum) return "Right";
        return "";

    }

    public static int getTreeSum(int[] arr, int i) {
        if (i > arr.length - 1 || arr[i] == -1) return 0;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int sum;
        sum = arr[i] + getTreeSum(arr, leftChild) + getTreeSum(arr, rightChild);
        return sum;
    }
    ////

    // Reverse a String
    public static String reverse(String str) {
        if (str == null) throw new IllegalArgumentException("Null is not valid input");

        StringBuilder out = new StringBuilder();

        char[] chars = str.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--)
            out.append(chars[i]);

        return out.toString();
    }

    // String contains vowels
    public static boolean stringContainsVowels(String str) {
        return str.toLowerCase().matches(".*[aeiou].*");
    }

    // Check if number is prime
    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Check list contains only odd numbers
    public static boolean onlyOddNumbers(List<Integer> list) {
        for (int i : list) {
            if (i % 2 == 0)
                return false;
        }

        return true;
    }

    // OR
    public static boolean onlyOddNumbersParallel(List<Integer> list) {
        return list
                .parallelStream() // parallel stream for faster processing
                .anyMatch(x -> x % 2 != 0); // return as soon as any elements match the condition
    }

    // Check String is palindrome
    public static boolean checkPalindromeString(String input) {
        boolean result = true;
        int length = input.length();

        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1)) {
                result = false;
                break;
            }
        }

        return result;
    }

    // Factorial of an integer
    public static long factorial(long n) {
        if (n == 1)
            return 1;
        else
            return (n * factorial(n - 1));
    }

    // Binary search algorithm
    public static int binarySearch(int[] arr, int low, int high, int key) {
        int mid = (low + high) / 2;

        while (low <= high) {
            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] == key) {
                return mid;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }

        return -1;
    }

    // Find String in file
    boolean findStringInFile(String filePath, String str) throws FileNotFoundException {
        File file = new File(filePath);

        Scanner scanner = new Scanner(file);

        // read the file line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(str)) {
                scanner.close();
                return true;
            }
        }
        scanner.close();

        return false;
    }

    // Find each char count in String
    public static void charCountInString(String str) {
        char[] chars = str.toCharArray();

        Map<Character, Integer> charsCount = new HashMap<>();

        for (char c : chars) {
            if (charsCount.containsKey(c)) {
                charsCount.put(c, charsCount.get(c) + 1);
            } else
                charsCount.put(c, 1);
        }

        System.out.println(charsCount); // i.e. {a=2, A=1, b=2, B=1, c=2, C=1, d=2, D=1}
    }

    public static void wordCountInString(String str) {
        String[] split = str.split(" ");

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : split) {
            if (map.containsKey(s)) {
                int count = map.get(s);
                map.put(s, count + 1);
            } else {
                map.put(s, 1);
            }
        }
        System.out.println(map); // i.e. {Saket=2, by=1, this=1, This=1, is=2, done=1}
    }

    // Bucket sort array and print sorted array
    public static void bucketSort(int[] array, int min, int max) {
        int range = max - min + 1;
        int[] result = new int[range];
        for (int i : array) {
            result[i]++;
        }
        System.out.println(Arrays.toString(result));
//        for (int i = 0; i < result.length; i++) {
//            for (int j = 0; j < result[i]; j++) {
//                System.out.print(i + ", ");
//            }
//        }
    }

    public static void checkerBoard() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int playerX = in.nextInt();
            int playerY = in.nextInt();
            System.out.println(findWinner(playerX, playerY));
        }
    }

    private static String findWinner(int x, int y) {
        return (x - 1) % 4 < 2 && (y - 1) % 4 < 2 ? "Second" : "First";
    }
}
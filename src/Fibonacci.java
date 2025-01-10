import java.util.*;

public class Fibonacci {

    /**
     * This is the most optimal solution as after we compute the results, we save them!, so
     * we don't have to compute them again when calling fibonacci(n - 2). Note this could
     * also be an ArrayList
     */
    public static Map<Integer, Integer> fibonacciResults = new HashMap<Integer, Integer>();
    /*
    fib(n) = f(n-1) + f(n-2)
    f(0) = 0
    f(1) = 1
    f(2) = 1
    f(3) = 2
    f(4) = 3
    f(5) = 5...
    Time Complexity: O(2^N) // exponential
    Space Complexity: O(N)
    def fibonacci(n):
        if n <= 0:
            return 0
        else if n == 1:
            return 1
        return  fibonacci(n - 1) + fibonacci(n - 2)
     */
    public static int fibonacciSimpleSolution(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    /*
    factorial function recursion
    Time Complexity: O(N)
    Space Complexity: O(N)
    fact(n) = n * fact(n-1)
    f(0) = 1
    def factorial(n:
        if n <= 0:
            return 1
        return n * factorial(n-1)
     */

    /*
    Recursive find on binary tree
    def find(node, value):
        if not node:
            return False
        if value == node.value:
            return True
        elif value < node:
            return find(node.left, value)
        else:
            return find(node.right, value)
     */

    public static int fibonacci(int n) {
        if (fibonacciResults.get(n) != null) {
            return fibonacciResults.get(n);
        }

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int number = fibonacci(n - 1) + fibonacci(n - 2);
            fibonacciResults.put(n, number);
            return number;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
        System.out.println(fibonacciSimpleSolution(n));
    }
}

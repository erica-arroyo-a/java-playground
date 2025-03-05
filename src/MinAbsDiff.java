import java.util.*;

public class MinAbsDiff {
    public static void processStream(int[] stream, int k) {
        Deque<Integer> window = new LinkedList<>();  // Maintains the last k elements
        TreeSet<Integer> sortedSet = new TreeSet<>();  // Keeps elements sorted for fast min-diff calculation

        for (int num : stream) {
            // Remove the oldest element if the window exceeds k
            if (window.size() == k) {
                int removed = window.pollFirst();  // Remove from queue
                sortedSet.remove(removed);         // Remove from TreeSet
            }

            // Find the closest values using TreeSet
            Integer lower = sortedSet.floor(num);  // Closest smaller or equal element
            Integer higher = sortedSet.ceiling(num);  // Closest larger or equal element

            int minDiff = Integer.MAX_VALUE;
            if (lower != null) minDiff = Math.min(minDiff, Math.abs(num - lower));
            if (higher != null) minDiff = Math.min(minDiff, Math.abs(num - higher));

            // Insert new element into both structures
            window.addLast(num);
            sortedSet.add(num);

            // Print min absolute difference when at least 2 elements exist
            if (window.size() >= 2) {
                System.out.println("Min Absolute Difference in last " + k + " elements: " + minDiff);
            }
        }
    }

    public static void main(String[] args) {
        int[] stream = {3, 8, -10, 23, 19, -4, -14, 27};
        int k = 3;
        processStream(stream, k);
    }
}

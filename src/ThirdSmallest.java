import java.util.PriorityQueue;

public class ThirdSmallest {
    public static Integer thirdSmallestLinear(int[] arr) {
        if (arr.length < 3) return null; // Not enough elements

        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, third = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < first) {
                third = second;
                second = first;
                first = num;
            } else if (num > first && num < second) {
                third = second;
                second = num;
            } else if (num > second && num < third) {
                third = num;
            }
        }

        return (third == Integer.MAX_VALUE) ? null : third; // Handle cases where third smallest doesn't exist
    }

    public static Integer thirdSmallestHeap(int[] arr) {
        if (arr.length < 3) return null; // Not enough elements

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
        }

        for (int i = 0; i < 2; i++) {
            minHeap.poll(); // Remove first two smallest elements
        }
        return minHeap.poll(); // Third smallest
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 9, 2};
        // Output: 3
        System.out.println(thirdSmallestLinear(arr));
        System.out.println(thirdSmallestHeap(arr));
    }
}

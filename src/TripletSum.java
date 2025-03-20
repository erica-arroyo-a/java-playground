import java.util.*;

/**
 * Given an array of integers, and a query number k.
 * Write a function that finds all the triplets in the array that sum up to the query number k.
 *
 * Example 1
 * Input:
 * nums = [1, 2, 3, 4, 5]
 * k = 6
 * Output:
 * count_triplets(nums, k) -> 1
 * In this case, there is only one triplet that sums up to 6: (1, 2, 3).
 *
 * Example 2:
 * Input:
 * nums = [10, 10, 20, 30, 40]
 * k = 60
 * Output:
 * count_triplets(nums, k) -> 3
 * triplets that sum up to 60: (10, 10, 40), (10, 20, 30), and (10, 20, 30).
 */
public class TripletSum {
    public static List<List<Integer>> findTriplets(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // Step 1: Sort the array

        for (int i = 0; i < arr.length - 2; i++) {
            //if (i > 0 && arr[i] == arr[i - 1]) continue; // Skip duplicates
            int left = i + 1, right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == k) {
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    // Move pointers and skip duplicates
                    while (left < right && arr[left] == arr[left + 1]) left++;
                    while (left < right && arr[right] == arr[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < k) {
                    left++; // Increase sum
                } else {
                    right--; // Decrease sum
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5}; // k = 6
        int[] arr2 = {10, 10, 20, 30, 40}; // k = 60
        List<List<Integer>> triplets1 = findTriplets(arr1, 6);
        List<List<Integer>> triplets2 = findTriplets(arr2, 60);
        System.out.println(triplets1.size() + " -> " + triplets1);
        System.out.println(triplets2.size() + " -> " + triplets2);
    }
}

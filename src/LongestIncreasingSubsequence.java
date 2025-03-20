import java.util.Arrays;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * A subsequence is an array that can be derived from another array by deleting some or no elements
 * without changing the order of the remaining elements.

 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 */
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Initialize all to 1

        int maxLIS = 1; // Store the max LIS found

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }

    public static void main(String[] args) {
        int[] example1 = {10,9,2,5,3,7,101,18};
        int[] example2 = {0,1,0,3,2,3};
        int[] example3 = {7,7,7,7,7,7,7};
        System.out.println("Length of LIS: " + lengthOfLIS(example1)); // Output: 4
        System.out.println("Length of LIS: " + lengthOfLIS(example2)); // Output: 4
        System.out.println("Length of LIS: " + lengthOfLIS(example3)); // Output: 1
    }
}

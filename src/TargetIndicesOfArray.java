import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a 0-indexed integer array nums and a target element target.
 *
 * A target index is an index i such that nums[i] == target.
 *
 * Return a list of the target indices of nums after sorting nums in non-decreasing order.
 * If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
 *
 * Example 1:
 * Input: nums = [1,2,5,2,3], target = 2
 * Output: [1,2]
 * Explanation: After sorting, nums is [1,2,2,3,5].
 * The indices where nums[i] == 2 are 1 and 2.
 *
 * Example 2:
 * Input: nums = [1,2,5,2,3], target = 3
 * Output: [3]
 * Explanation: After sorting, nums is [1,2,2,3,5].
 * The index where nums[i] == 3 is 3.
 *
 * Example 3:
 * Input: nums = [1,2,5,2,3], target = 5
 * Output: [4]
 * Explanation: After sorting, nums is [1,2,2,3,5].
 * The index where nums[i] == 5 is 4.
 */

public class TargetIndicesOfArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0, lessthan = 0;
        for (int n : nums) {
            if (n == target) count++;
            if (n < target) lessthan++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(lessthan++);
        }
        return result;
    }

    public List<Integer> targetIndicesV2(int[] nums, int target) {
        List<Integer> result=new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=0; i<n; i++){
            if(nums[i] == target){
                result.add(i);
            }
        }
        return result;
    }
}

import java.util.HashSet;
import java.util.Set;

/**
 * You are given two integer arrays nums1 and nums2 of sizes n and m, respectively. Calculate the following values:
 * answer1 : the number of indices i such that nums1[i] exists in nums2.
 * answer2 : the number of indices i such that nums2[i] exists in nums1.
 * Return [answer1,answer2].
 *
 * Example 1:
 * Input: nums1 = [2,3,2], nums2 = [1,2]
 * Output: [2,1]
 *
 * Example 2:
 * Input: nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]
 * Output: [3,4]
 *
 * Example 3:
 * Input: nums1 = [3,4,2,3], nums2 = [1,5]
 * Output: [0,0]
 */
public class CommonElementsInArrays {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num: nums1)
            set1.add(num);
        for (int num: nums2)
            set2.add(num);
        int count1=0;
        for (int num:nums1){
            if (set2.contains(num))
                count1++;
        }
        int count2=0;
        for (int num:nums2){
            if (set1.contains(num))
                count2++;
        }
        return new int[] {count1,count2};
    }
}

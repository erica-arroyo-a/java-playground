public class MergeSortedArrays {
    /*
        Example 1:
        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output: [1,2,2,3,5,6]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1, pointer2 = n - 1, i = m + n - 1;

        while (pointer2 >= 0) {
            if (pointer1 >= 0 && nums1[pointer1] > nums2[pointer2]) {
                nums1[i--] = nums1[pointer1--];
            } else {
                nums1[i--] = nums2[pointer2--];
            }
        }
    }
}

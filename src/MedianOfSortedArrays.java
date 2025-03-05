import java.util.Arrays;

public class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0;
        int nums1Size = nums1.length, nums2Size = nums2.length, k = 0;
        int merged[] = new int[nums1Size + nums2Size];

        // merge arrays
        for (int i = 0; i < nums1Size; i++) {
            merged[k++] = nums1[i];
        }
        for (int j = 0; j < nums2Size; j++) {
            merged[k++] = nums2[j];
        }

        // sort merged array
        Arrays.sort(merged);

        int size = merged.length, middleIndex = size / 2;

        // find median based on array size
        if (size % 2 == 1) { // odd
            median = (double) merged[middleIndex];
        } else { // even
            int med1 = merged[middleIndex];
            int med2 = merged[size / 2 - 1];
            median = (double) ((med1 + med2) / 2.0);
        }

        return median;
    }
}

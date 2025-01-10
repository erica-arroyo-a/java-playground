public class SingleNonDuplicateInArray {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            boolean c1 = (middle % 2 == 0 && nums[middle] == nums[middle + 1]);
            boolean c2 = (middle % 2 == 1 && nums[middle] == nums[middle - 1]);
            if (c1 || c2) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return nums[left];
    }
}

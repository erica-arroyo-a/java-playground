class MaxArea {
    // container with most water
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int lefttHeight = height[left];
            int rightHeight = height[right];

            int area = Math.min(lefttHeight, rightHeight) * (right - left);
            max = Math.max(max, area);

            if (lefttHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}

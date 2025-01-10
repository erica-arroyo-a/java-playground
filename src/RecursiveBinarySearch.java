// Java Program to Illustrate Recursive Binary Search

class RecursiveBinarySearch {
    // Recursive binary search
    int binarySearch(int[] arr, int left, int right, int x)
    {
        if (left <= right) {
            // get the middle
            int middle = (left + right) / 2;

            if (arr[middle] > x) {
                // search right
                return binarySearch(arr, left, middle - 1, x);
            } else if (arr[middle] < x) {
                // search left
                return binarySearch(arr, middle + 1, right, x);
            }
            return middle;
        }
        // x not found
        return -1;
    }

    public static void main(String[] args)
    {
        RecursiveBinarySearch ob = new RecursiveBinarySearch();
        int[] arr = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;

        int result = ob.binarySearch(arr, 0, n - 1, x);

        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}

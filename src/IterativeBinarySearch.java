// Iterative Binary Search
class IterativeBinarySearch {

    // Returns index of x if it is present in arr[], else return -1
    int binarySearch(int[] arr, int x)
    {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;

            if (arr[middle] == x)
                return middle;
            if (arr[middle] < x)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        IterativeBinarySearch ob = new IterativeBinarySearch();
        int[] arr = { 2, 3, 4, 10, 40 };
        int x = 10;
        int result = ob.binarySearch(arr, x);

        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}


// Optimized java implementation of Bubble sort

import java.io.*;

class BubbleSort {
    static void bubbleSort(int[] arr, int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }

    // version 2
    static void bubbleSort2(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        int[] arr2 = { 50, 99, 10, 1, 0, 100, 89 };
        int n = arr.length;
        System.out.println("Original array: ");
        printArray(arr);
        bubbleSort(arr, n);
        System.out.println("Sorted array: ");
        printArray(arr);
        System.out.println("Original array: ");
        printArray(arr2);
        bubbleSort2(arr2);
        System.out.println("Sorted array: ");
        printArray(arr2);
    }
}

package SORTING;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // Swap arr[i] and arr[min_idx]
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }

    public static void main (String[] args) {
        int[] arr = {89, 85, 69, 98, 56, 88};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
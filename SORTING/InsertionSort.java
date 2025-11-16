package SORTING;
import java.util.Arrays;


public class InsertionSort {
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length - 1; i++) {
            int curr = arr[i];
            int prev = i - 1;
            // Finding out the current position to insert
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // Insertion
            arr[prev + 1] = curr;
        }
    }
    public static void main(String[] args) {
        int arr[] = {89, 85, 69, 98, 56, 88};

        insertionSort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
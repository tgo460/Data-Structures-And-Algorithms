import java.util.*;

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        for(int turn = 0; turn < arr.length - 1; turn++) {
            for(int j = 0; j < arr.length - 1 - turn; j++) {
                if(arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {3, 1, 6, 7, 8, 4, 9};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
package SORTING;
import java.util.Arrays;

public class InbuiltSort {
    public static void inbuiltSort(int arr[]) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int arr[] = {89, 85, 69, 98, 56, 88};
       inbuiltSort(arr);
    }
}
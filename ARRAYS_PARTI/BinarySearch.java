package ARRAYS_PARTI;
import java.util.*;


public class BinarySearch {

    public static int binarySearch(int numbers[], int key) {
         int start = 0, end = numbers.length - 1;

         while (start <= end) {
            int mid = (start + end) / 2;

            // Comparisons
            if (numbers[mid] == key) {
                return mid;
            }
            if (numbers[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
         }
         return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers[] = {2, 4, 6, 8, 10, 12, 14};
        System.out.println("Enter the key to be searched: ");
        int key = sc.nextInt();

        int index = binarySearch(numbers, key);

        System.out.println("Found at index: " + index);

        sc.close();
    }
}

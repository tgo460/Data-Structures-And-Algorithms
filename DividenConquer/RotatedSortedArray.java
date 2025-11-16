public class RotatedSortedArray {
    public static int rotatedSorted(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == target) {
                return mid;
            }

            // check if left half sorted
            if (arr[start] <= arr[mid]) {
                // check if the target is in the left half
                if (arr[start] <= target && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } 
            
            // Else, right half is sorted

            else {
                if(arr[mid] < target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return - 1; // Target not found
    }

// Recursion Method
    /*

    public class RotatedArraySearch {

    public static int searchInRotatedArray(int[] arr, int target) {
        return binarySearchRotated(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchRotated(int[] arr, int target, int start, int end) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        // Left half is sorted
        if (arr[start] <= arr[mid]) {
            if (arr[start] <= target && target < arr[mid]) {
                return binarySearchRotated(arr, target, start, mid - 1);
            } else {
                return binarySearchRotated(arr, target, mid + 1, end);
            }
        }

        // Right half is sorted
        else {
            if (arr[mid] < target && target <= arr[end]) {
                return binarySearchRotated(arr, target, mid + 1, end);
            } else {
                return binarySearchRotated(arr, target, start, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int result = searchInRotatedArray(nums, target);
        System.out.println("Target found at index: " + result);
    }
}


    */

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = rotatedSorted(arr, target);
        System.out.println("Target found at index : " + result);
    }
}
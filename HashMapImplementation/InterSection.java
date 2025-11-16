package HashMapImplementation;

import java.util.*;

public class InterSection {
    public static int[] intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> resultList = new ArrayList<>();

        for(int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for(int j = 0; j < arr2.length; j++) {
            if(set.contains(arr2[j])) {
                resultList.add(arr2[j]);
                set.remove(arr2[j]);
            }
        }

        // Convert ArrayList to array

        int[] result = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};

        int[] intersected = intersection(arr1, arr2);

        System.out.println("Intersected element: " + Arrays.toString(intersected));
        System.out.println("Intersection count : " + intersected.length);
    }
}
import java.util.*;

public class MajorityElement {
    // public static int majorityElement(int[] arr) {
    //     HashMap<Integer, Integer> counts = new HashMap<>();
        
    //     int n = arr.length;

    //     for(int i = 0; i < n; i++) {
    //         int currentNum = arr[i];

    //         counts.put(currentNum, counts.getOrDefault(currentNum, 0) + 1);
    //         // if(counts.get(currentNum) > n / 3) {
    //         //     return currentNum;
    //         // }
    //         return currentNum;
    //     }
        

    //     //Find the highest frequency (number of times the majority element appears)
    //     int maxCount = 0;

    //     for(int count : counts.values()) {
    //         if(count > maxCount) {
    //             maxCount = count;
    //         }
    //     }

    //     int[] countfre = {maxCount,}
    //     return maxCount;
        
    // }


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 1, 3, 1, 5, 1};

        // System.out.println(majorityElement(arr));

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else {
                map.put(arr[i], 1);
            }
        }

        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet) {
            if(map.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }
    }
}
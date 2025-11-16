import java.util.*;

public class MostFrevnt {
    public int mostFrequent(ArrayList<Integer> nums, int key) {
        int[] result = new int[1000];

        for(int i = 0; i < nums.size() -1; i++) {
            if(nums.get(i) == key) {
                result[nums.get(i + 1) - 1]++;
            }
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;

        for(int i = 0; i < 1000; i++) {
            if(result[i] > max) {
                max = result[i];
                ans = i + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 100, 200, 1, 100)); 
        int key = 1;

        MostFrevnt mf = new MostFrevnt();
        System.out.println(mf.mostFrequent(nums, key));

    }

}
// import java.util.ArrayList;
// import java.util.Collections;
// OR
import java.util.*;

public class Swap2Numbers {

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
    public static void main(String args[]) {
        // ArrayList<Integer> list = new ArrayList<>();

        // list.add(2);
        // list.add(5);
        // list.add(9);
        // list.add(3);
        // list.add(6);

        // int idx1 = 1, idx2 = 3;
        // System.out.println(list);
        // swap(list, idx1, idx2);
        // System.out.println(list);

        // Sort Method
        // System.out.println(list);
        // Collections.sort(list);
        // System.out.println(list);

        // // Descending
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        // Comparator fnx logic
        // 2D ArrayList

        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1); list.add(2);
        // mainList.add(list);

        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(3); list2.add(4);

        // mainList.add(list2);


        // for(int i = 0; i < mainList.size(); i++) {
        //     ArrayList<Integer> currList = mainList.get(i);
        //     for (int j = 0; j < currList.size(); j++) {
        //         System.out.print(currList.get(j) + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println(mainList);


        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list1.add(i * 1);
            list2.add(i * 2);
            list3.add(i * 3);
        }

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        System.out.print(mainList);
        System.out.println();

        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for(int j = 0;j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }
}
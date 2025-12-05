import java.util.*;
import java.util.HashSet;

public class Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);

        System.out.println(set);

        // if(set.contains(0)) {
        //     System.out.println("Set contains 0");
        // }

        // if(set.contains(2)) {
        //     System.out.println("Set Contains 2");
        // }

        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        for(int num : set) {
            System.out.println(num);
        }
    }
}
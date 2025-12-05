import java.util.HashMap;
import java.util.TreeMap;

public class TreeMapUsingHash {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 120);
        hm.put("US", 30);

        System.out.println(hm);

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 140);
        tm.put("USA", 40);
        tm.put("China", 130);

        System.out.println(tm);
    }
}
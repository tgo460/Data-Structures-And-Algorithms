import java.util.LinkedHashMap;

public class LinkedHashMapOrd {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 140);
        lhm.put("China", 120);
        lhm.put("USA", 35);

        System.out.println(lhm);
    }
}
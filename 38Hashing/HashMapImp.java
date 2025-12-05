import java.util.HashMap;
public class HashMapImp {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 120);
        hm.put("US", 30);

        System.out.println(hm);
    }
}
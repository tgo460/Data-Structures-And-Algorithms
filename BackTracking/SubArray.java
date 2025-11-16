public class SubArray {


    public static void findSubSets(String str, String ans, int i) {
        // base case
        if(i == str.length()) {
            System.out.println(ans);
            return;
        }

        // recursion
        // yes choice
        findSubSets(str, ans + str.charAt(i), i + 1);

        // No choice
        findSubSets(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        findSubSets(str, "",  0);
    }
}
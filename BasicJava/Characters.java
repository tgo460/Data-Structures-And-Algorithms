package BasicJava;
public class Characters {
    public static void main(String[] args) {
        char ch = 'A';
        int n = 4;

        for (int line = 1; line <= n; line++) {
            // Inner loop
            for (int chars = 1; chars <= line; chars++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
}

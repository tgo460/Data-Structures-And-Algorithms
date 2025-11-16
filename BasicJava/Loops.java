package BasicJava;
import java.util.*; 
public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;

        do {
            System.out.print("Enter a number : ");
            int n = sc.nextInt();

            if(n % 10 == 0) {
                flag = true;
            }
            System.out.println(n);
        } while(!flag);

        sc.close();
    }
}

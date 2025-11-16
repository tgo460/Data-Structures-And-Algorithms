package BasicJava;
import java.util.Scanner;
public class UserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Your Name : ");
        String userName = scanner.nextLine();
        System.out.println("Welcome Back " + userName + "!");
        scanner.close();
    }
}

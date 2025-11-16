package FunctionsinJava;
import java.util.*;

public class Practice {
    // // public static int avg(int a, int b, int c) {
    // // int avg = (a + b + c) / 3;
    // // return avg;
    // // }

    // public static boolean isEven(int n) {
    // return n % 2 == 0;
    // }

    // public static void palindrome(int n) {
    //     int rev = 0;
    //     int temp = n;
    //     while (temp > 0) {
    //         int rem = temp % 10;
    //         rev = rev * 10 + rem;
    //         temp = temp / 10;
    //     }
    //     if (rev == n) {
    //         System.out.println(n + " is a palindrome.");
    //     } else {
    //         System.out.println(n + " is not a palindrome.");
    //         System.out.println("The number sequence is: " + rev);
    //     }

    // }

    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);


       System.out.println("Enter a number:");
       int n = sc.nextInt();

       System.out.print("Sum of digits: " + sumDigits(n));
       sc.close();
    }


    public static int sumDigits(int n) {
        int sumOfDigits = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            sumOfDigits += lastDigit;
            n /= 10;
        }
        return sumOfDigits;
    }

}

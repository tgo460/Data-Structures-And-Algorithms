package BasicJava;
// Input in Java
// In Java, you can read input from the user using the Scanner class. The Scanner class is a part of the java.util package, which is imported by default. To use the Scanner class, you need to create an object of the Scanner class and use its methods to read input.

// The following example reads a string input from the user and prints it back:


// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Enter a string: ");
//         String input = scanner.nextLine();
//         System.out.println("You entered: " + input);
//         scanner.close();
//     }
// }
// In the above example, we first import the Scanner class from the java.util package. Then, we create an object of the Scanner class and pass System.in as an argument to the constructor to read input from the standard input stream (keyboard).

// We then use the nextLine() method to read a string input from the user and store it in the input variable. Finally, we print the input string using System.out.println(). The scanner.close() method is used to close the scanner object and release system resources.

// The Scanner class provides various methods to read different types of input, such as nextInt(), nextDouble(), nextBoolean(), etc. You can use these methods to read different types of input from the user.

// Note: The Scanner class is a resource that needs to be closed after use to avoid memory leaks. You can close the Scanner object by calling the close() method.

// In the next section, we will learn how to read different types of input from the user using the Scanner class.

// Reading Different Types of Input
// In Java, you can read different types of input from the user using the Scanner class. The Scanner class provides various methods to read different types of input, such as integers, floating-point numbers, characters, and strings.

// The following example reads an integer input from the user and prints it back:

// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Enter an integer: ");
//         int input = scanner.nextInt();
//         System.out.println("You entered: " + input);
//         scanner.close();
//     }
// }


// nextInt() method reads an integer input from the user and returns it. Similarly, you can use the nextDouble() method to read a double input, the nextBoolean() method to read a boolean input, and the next() method to read a string input.

// nextLine() method reads a string input until the end of the line. It reads the input until it encounters a newline character (\n) and returns the input as a string.

// nextByte(), nextShort(), nextLong(), nextFloat(), and nextBigInteger() methods are used to read byte, short, long, float, and BigInteger inputs, respectively.


import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int input = scanner.nextInt();
        System.out.println("You entered: " + input);

        scanner.close();
    }
}
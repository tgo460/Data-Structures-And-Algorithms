package BasicJava;
public class Pattern {
    public static void main(String[] args) {
        // int n = 4;  // controls height of the diamond's top half
        // 
        // // Print the upper half of the diamond
        // for (int i = 1; i <= n; i++) {
        //     // Print spaces
        //     // The outer loop is for the number of lines
        //     // The inner loop prints the spaces
        //     for (int space = 1; space <= (n - i); space++) {
        //         System.out.print(" ");
        //     }
        //     // Print stars
        //     // The outer loop is for the number of lines
        //     // The inner loop prints the stars
        //     for (int star = 1; star <= (2 * i - 1); star++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // // Print the lower half of the diamond
        // for (int i = n - 1; i >= 1; i--) {
        //     // Print spaces
        //     // The outer loop is for the number of lines
        //     // The inner loop prints the spaces
        //     for (int space = 1; space <= (n - i); space++) {
        //         System.out.print(" ");
        //     }
        //     // Print stars
        //     // The outer loop is for the number of lines
        //     // The inner loop prints the stars
        //     for (int star = 1; star <= (2 * i - 1); star++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // for (int line = 1; line <= 4; line++) {
        //     for (int star = 1; star <= line; star++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        int n = 4;
        // Print the pattern
        // The outer loop is for the number of lines
        // The inner loop prints the stars
        for (int line = 1; line <=n; line++) {
            for (int star =  1; star <= (n - line + 1); star++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // int n = 4;

        // // Print the pattern
        // for (int line = 1; line <= n; line++) {
        //     for (int number = 1; number <= line; number++) {
        //         System.out.print(number + " ");
        //     }
        //     System.out.println();
        // }

    }
}


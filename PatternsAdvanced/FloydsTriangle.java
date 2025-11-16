package PatternsAdvanced;

public class FloydsTriangle {
    public static void floydsTriangle(int n) {
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            // Inner-loop to itirate number of columns
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.err.println();
        }
    }


    public static void zero_one_triangle(int n) {
        // Outer-loop
        for (int i = 1; i <= n; i++) {
            // Inner-loop
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        floydsTriangle(5);
        // zero_one_triangle(5);
    }
}
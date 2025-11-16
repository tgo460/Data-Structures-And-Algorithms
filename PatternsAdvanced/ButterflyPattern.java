package PatternsAdvanced;

public interface ButterflyPattern {
    public static void butterfly(int n) {
        // First Half
        for (int i = 1; i <= n; i++) {
            // inner loop for stars - 1
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Spaces - 2 * (n - i)
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            // star - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd Half

        for (int i = n; i >= 1; i--) {
            // inner loop for stars - 1
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Spaces - 2 * (n - i)
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            // star - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        butterfly(7);
    }
}

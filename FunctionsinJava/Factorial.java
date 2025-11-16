package FunctionsinJava;

public class Factorial {


    public static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        return f;
    }


    public static int binCoeff(int n, int r) {
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nmr = factorial(n -r);

        return fact_n / (fact_r * fact_nmr);
    }

    public static void main(String[] args) {
        System.out.println(factorial(7));

        System.out.println(binCoeff(7, 3));
    }
}

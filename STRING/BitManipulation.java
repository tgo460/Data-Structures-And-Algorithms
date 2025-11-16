package STRING;

import java.util.*;

public class BitManipulation {

    public static void oddOrEven(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            System.out.println("even Number");
        } else {
            System.out.println("odd Number");
        }
    }
    public static void main (String[] args) {
        oddOrEven(3);
        oddOrEven(11);
        oddOrEven(10);
    }
}
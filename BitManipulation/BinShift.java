public class BinShift {

    /*
    // public static void oddOrEven(int n) {
    //     int bitMask = 1;
    //     if((n & bitMask) == 0) {
    //         System.out.println("Even Number");
    //     } else {
    //         System.out.println("Odd Number");
    //     }
    // }

    // public static int getIthBit(int n, int i) {
    //     int bitMask = 1<<i;
    //     if((n & bitMask) == 0) {
    //          return 0;
    //     } else {
    //         return 1;
    //     }
    // }

    // public static int setIthBit(int n, int i) {
    //     int bitMask = 1 << i;
    //     return n | bitMask;
    // }
    
    // public static int updateIthBit(int n, int i, int newBit) {
    //     if(newBit == 0) {
    //         return clearIthBit(n, 1);
    //     } else {
    //         return setIthBit();
    //     }

    //     n = clearIthBit(n, i);

    //     int bitMask = newBit<<i;
    //     return n | bitMask; 
    // }//
*/
    public static int clearLastIBit(int n, int i) {
        int bitMask = (~0)<<i;
        return n & bitMask;
    }

    public static int clearBitInRange(int n, int i, int j) {
        int a = ((~0)<<(j+1));
        int b = (1<<i)-1;
        int bitMask = a | b;
        return n & bitMask;
    }

    public static boolean isPowerOfTwo(int n) {
        return (n&(n - 1)) == 0;
    }

    public static int countSetBits(int n) {
        int count = 0;
        while(n > 0) {
            if((n & 1) != 0) { // Check our LSB
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int fastExpo(int a, int n) {
        int ans = 1;

        while(n > 0) {
            if((n & 1) != 0) {  // check LSB
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fastExpo(3, 5));
        System.out.println(fastExpo(5, 3));
        // System.out.println(countSetBits(10));

        // System.out.println(isPowerOfTwo(8));

        // System.out.println(clearBitInRange(10, 2, 4));


        // int ls = 5<<2; // Left Shift by 2 bits to left
        // int rs = 5>>2; // Right Shift by 2 bits to right
        // System.out.println(ls);
        // System.out.println(rs);

        // System.out.println(Integer.toBinaryString(5));

        // String val = "10110010";
        // int value = Integer.parseInt(val, 2);
        // System.out.println(value);

        // oddOrEven(7);
        // System.out.println(getIthBit(10, 1));
        // System.out.println(setIthBit(10, 2));
        // System.out.println(updateIthBit(10, 2, 1));
        // System.out.println(clearLastIBit(15, 2));
    }
}
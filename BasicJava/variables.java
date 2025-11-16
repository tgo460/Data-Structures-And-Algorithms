

package BasicJava;
public class variables {
    public static void main(String[] args) {
        int  number = 10;
        double decimal = 10.5;
        char letter = 'A';
        boolean flag = true;
        String name = "John Doe";

        System.out.println("Number: " + number);
        System.out.println("Decimal: " + decimal);
        System.out.println("Letter: " + letter);
        System.out.println("Flag: " + flag);
        System.out.println("Name: " + name);
    }
}


// Size of data types
// The size of a data type determines the range of values that can be stored in it. The size of a data type is platform-dependent, meaning it can vary depending on the operating system and the hardware. The size of a data type is measured in bits.

// The following table shows the size of the primitive data types in Java:

// Type     Size        Size        Range
//          (bits)      (bytes)     
// byte     8           1           -128 to 127
// short    16          2           -32768 to 32767
// int      32          4           -2147483648 to 2147483647
// long     64          8           -9223372036854775808 to 9223372036854775807
// float    32          4           1.4E-45 to 3.4028235E38
// double   64          8           4.9E-324 to 1.7976931348623157E308
// char     16          2           '\u0000' to '\uffff'
// boolean  1           1           true or false
// String   Variable    Variable    Variable

// The size of the data types in Java is fixed, regardless of the platform. For example, the size of the int data type is always 32 bits (4 bytes), regardless of the operating system or hardware.



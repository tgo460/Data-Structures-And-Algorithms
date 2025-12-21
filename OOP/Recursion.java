public class Recursion {
    public static void printDec(int n) {
        if(n == 1) {
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }


    public static void printInc(int n) {
        if(n == 1) {
            System.out.print(1 + " ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }

        int fnm1 = fact(n-1);
        int fn = n * fact(n-1);
        return fn;
    }

    public static int sumon(int n) {
        if (n == 1) {
            return n;
        }
        int snm1 = sumon(n - 1);
        int sn = n + snm1;
        return sn;
    }

    // Calculate nth term in fibonacci
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int fnm1 = fib(n - 1);
        int fnm2 = fib(n - 2);
        int fn = fnm1 + fnm2;
        return fn;
    }


    public static boolean isSorted(int arr[], int i) {

        if (i == arr.length - 1) {
            return true;
        }


        if (arr[i] > arr[i+ 1]) {
            return false;
        }

        return isSorted(arr, i + 1);
    }

    // First Occurance
    public static int firstOccurance(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }

        return firstOccurance(arr, key, i+1);
    }

    // Last Occurance

    public static int lastOccurance(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }

        int isFound = lastOccurance(arr, key, i+1);

        if (isFound == -1 && arr[i] == key) {
            return i;
        }

        // check for all other cases
        return isFound;
    }


    public static int power(int x, int n) {

        if (n == 0) {
            return 1;
        }
        // int xnm1 = power(x, n - 1);
        // int xn = x * xnm1;
        // return xn;

        return x * power(x, n - 1);
    }

    public static int optimizedPower(int a, int n) {

        if (n == 0) {
            return 1;
        }

        int halfPower = optimizedPower(a, n/2);
        int halfPowerSq = halfPower * halfPower;
        // int halfPowerSq = optimizedPower(a, n/2) * optimizedPower(a, n /2);

        // n is odd
        if (n % 2 != 0) {
            halfPowerSq = a * halfPowerSq;
        }
        return halfPowerSq;
    }

    // Tiling Problem
    public static int tilingProblem(int n) { // 2 x n (floor size)

        // base case 
        if (n == 0 || n == 1) {
            return 1;
        }

        // kaam
        // Vertical choice 
        int fnm1 = tilingProblem(n - 1);

        // horizontal choice
        int fnm2 = tilingProblem(n - 2);

        int totalWays = fnm1 + fnm2;
        return totalWays;


    }


    // Remove Duplicates in a string
    public static void removeDuplicate(String str, int idx, StringBuilder newStr, boolean map[]) {
        // base case
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }


        // work to do

        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            // duplicate
            removeDuplicate(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx+1, newStr.append(currChar), map);
        }
    }

    public static int friendsPairing(int n) {
        if(n == 1 || n == 2) {
            return n;
        }

        // // Choice
        // // Single
        // int fnm1 = friendsPairing(n - 1);

        // // pair

        // int fnm2 = friendsPairing(n - 2);

        // int pairWays = (n - 1) * fnm2;

        // int totalWays = fnm1 * pairWays;

        // return totalWays;

        // OR

        return friendsPairing(n - 1) + (n - 1) * friendsPairing(n - 2);

    }

    public static void printBinStrings(int n, int lastPlace, String str) {
        // Work to do
        // if (lastPlace == 0) {
        //     // sit on chair n
        //     PrintBinStrings(n - 1, 0, str.append("0"));
        //     PrintBinStrings(n - 1, 1, str.append("1"));
        // } else {
        //     PrintBinStrings(n - 1, 0, str.append("0"));
        // }

        // OR

        if (n == 0) {
            System.out.println(str);
            return;
        }

        printBinStrings(n - 1, 0, str+"0");
        if(lastPlace == 0) {
            printBinStrings(n - 1, 1, str+"1");
        }
    }

    public static void main(String[] args) {


        printBinStrings(3, 0, "");


        // System.out.println(friendsPairing(5));
        // String str = "ningappa";
        // removeDuplicate(str, 0, new StringBuilder(""), new boolean[26]);

        // System.out.println(tilingProblem(4));

        // int arr[] = {1, 5, 3, 4};
        // int arr[] = {1, 2, 3, 4};

        // System.out.println(isSorted(arr, 0));
        // printDec(n);
        // printInc(n);
        // System.out.println(fact(n));
        // System.out.println(sumon(n));
        // System.out.println(fib(n));

        // FirstOccurance
        // int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        // int arr[] = {5, 5, 5, 5};

        // System.out.println(firstOccurance(arr, 5, 0));

        // LasrOccurance
        // System.out.println(lastOccurance(arr, 5, 0));

        // System.out.println(power(2, 10));

        // int a = 2;
        // int n = 10;
        // System.out.println(optimizedPower(a, n));
    }
}
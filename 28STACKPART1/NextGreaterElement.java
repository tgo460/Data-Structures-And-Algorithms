import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3};
        Stack<Integer> s = new Stack<>();
        int nxtgreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // 1 While
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            // 2 if-else
            if(s.isEmpty()) {
                nxtgreater[i] = -1;
            } else {
                nxtgreater[i] = arr[s.peek()];
            }

            // 3 push in s
            s.push(i);

        }

        for(int i = 0; i < nxtgreater.length; i++) {
            System.out.print(nxtgreater[i] + " ");
        }
        System.out.println();

        // Next greater Right
        // Next greater left
        // Next Smaller Right
        // Next Smaller Left
    }
}
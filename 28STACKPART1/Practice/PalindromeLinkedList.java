import java.util.*;

public class PalindromeLinkedList {
   static class Node {
        int data;
        Node ptr;

        Node(int d) {
            ptr = null;
            data = d;
        }
    }

    public static void print(Stack<Integer> stack) {
        for(int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i)+ " ->");
        }
        
    }

    static boolean isPalindrome(Node head) {
        Node slow = head;
        Stack<Integer> stack = new Stack<>();

        // Step 1: push all elements to the stack
        while(slow != null) {
            stack.push(slow.data);
            slow = slow.ptr;
        }

        print(stack);

        // Step 2: Compare while poping from stack
        while(head != null) {
            int top = stack.pop();
            if(head.data != top) {
                return false;
            }
            head = head.ptr;
        }

        return true;
    }

    public static void main(String args[]) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 3 -> 2 -> 1
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);

        one.ptr = two;
        two.ptr = three;
        three.ptr = four;
        four.ptr = five;
        five.ptr = six;
        six.ptr = seven;

        boolean condition = isPalindrome(one);

        System.out.println("Palindrome : " + condition);
    }
}
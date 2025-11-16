// Implementation of  Stack and Queue Using Deque Interfacw

import java.util.*;

public class ImplStackUsingDeque {
    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data) {
            deque.addLast(data);
        }

        public int pop() {
            return deque.removeLast();
        }

        public int peek() {
            return deque.getLast();
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }
    }

    static class Queue {
        Deque<Integer> deque = new LinkedList<>();
        
        public void add(int data) {
            deque.addLast(data);
        }

        public int remove() {
            return deque.removeFirst();
        }

        public int peek() {
            return deque.getFirst(); 
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        Queue q = new Queue();

        s.push(1);
        s.push(2);
        s.push(3);

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("Peek = " + s.peek());

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }

        System.out.println();
        System.out.println("Peek = " + q.peek());
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}